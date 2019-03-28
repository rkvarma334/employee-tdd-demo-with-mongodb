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
    public Either<Exception, Boolean> createEmp(EmployeeState employeeState) {

       if (this.employeeList.stream().anyMatch(
               x->x.getEmployeeState().getUsername().equals(employeeState.getUsername()) ||
                   x.getEmployeeState().getMobileNum().equals(employeeState.getMobileNum()))) {
           return Either.left(new Exception("UserName or Mobile number already exist"));
       }

        if (this.employeeList.stream().anyMatch(x->x.getEmployeeState().getEmailId().equals(employeeState.getEmailId()))) {
            return Either.left(new Exception("Email Id already exist"));
        }

        Optional<Employee> empOptional = this.employeeList.stream().
                filter(x->x.getEmployeeState().getEmpId().equals(employeeState.getEmpId())).findAny();
        if (!empOptional.isPresent()){
           return Either.right(true);
        }
        return Either.left(new Exception("Employee registered already"));
    }

}
