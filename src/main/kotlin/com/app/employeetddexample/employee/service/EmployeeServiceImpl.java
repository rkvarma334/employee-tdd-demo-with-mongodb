package com.app.employeetddexample.employee.service;

import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeList;
import com.app.employeetddexample.employee.model.EmployeeState;
import com.app.employeetddexample.employee.repository.EmployeeRepo;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public Either<Exception,String> createEmployee(EmployeeState employeeState) {

       List<Employee> oldEmpList =   this.getAllEmps();
        EmployeeList oldEmployeeList = new EmployeeList(oldEmpList);
     Either either=   oldEmployeeList.createEmp(employeeState);
        if (either.isRight()){
            employeeRepo.save(employeeState);
            return Either.right(employeeState.getEmpId());
        }
        return Either.left(new Exception("emp registered already"));
    }

    @Override
    public List<Employee> getAllEmps() {

       List<EmployeeState> employeeStateList= employeeRepo.findAll();

      List<Employee> employeeList = employeeStateList.stream().map(x->new Employee(x)).collect(Collectors.toList());

        return employeeList;
    }


    @Override
    public Employee getEmpById(String empId) {

       Employee emp= employeeRepo.findByEmpId(empId);
        return emp;
    }


}
