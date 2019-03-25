package com.app.employeetddexample.employee.model;


import io.vavr.control.Either;

import java.util.List;
import java.util.Optional;

public class EmployeeList implements IEmployeeList {

   private List<Employee> employeeList;

   public EmployeeList(List<Employee> employeeList){
        this.employeeList=employeeList;
            }

    @Override
    public Boolean createEmployee( EmployeeState employeeState) {

        Optional<Employee> employee =  this.employeeList.stream().
                filter(x->x.getEmployeeState().getMobileNum().equals(employeeState.getMobileNum()) ||
                        x.getEmployeeState().getEmailId().equals(employeeState.getEmailId())).findAny();

        return !employee.isPresent();
    }

    @Override
    public Either<Exception,EmployeeState> createEmp(EmployeeState employeeState) {

     Optional<Employee> employeeOptional =  this.employeeList.stream().filter(x->x.getEmployeeState().getEmpId().equals(employeeState.getEmpId()) ||
                                      x.getEmployeeState().getMobileNum().equals(employeeState.getMobileNum())).findAny();

     if (!employeeOptional.isPresent()){

         String id =employeeOptional.get().createEmployee(employeeState);
     }

     return Either.left(new Exception("Employee already exit in db"));
    }
}
