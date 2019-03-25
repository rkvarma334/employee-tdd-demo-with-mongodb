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
    public String createEmployee(EmployeeState employeeState) {

     List<Employee> oldEmpList =   this.getAllEmps().stream().map(x->new Employee(employeeState)).collect(Collectors.toList());

        EmployeeList employeeList = new EmployeeList(oldEmpList);
        Either empEither =employeeList.createEmp(employeeState);

        if(empEither.isRight()){

        }




        return "";
    }

    @Override
    public Employee getEmpById(String empId) {

       Employee emp= employeeRepo.findByEmpId(empId);
        return emp;
    }

    @Override
    public List<EmployeeState> getAllEmps() {

      List<EmployeeState>employeeStateList=  employeeRepo.findAll();

        return employeeStateList;
    }
}
