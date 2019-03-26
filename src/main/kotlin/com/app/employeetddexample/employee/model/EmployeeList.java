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
        Optional<Employee> empOptional = this.employeeList.stream().
                filter(x->x.getEmployeeState().getEmpId().equals(employeeState.getEmpId()) ||
               x.getEmployeeState().getMobileNum().equals(employeeState.getMobileNum())).findAny();
        if (!empOptional.isPresent()){
           return Either.right(true);
        }
        return Either.left(new Exception("Emp already registered"));
    }

}
