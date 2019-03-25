package com.app.employeetddexample.employee.model;


import io.vavr.control.Either;

public interface IEmployeeList {


    Boolean createEmployee( EmployeeState employeeState);

    Either<Exception,EmployeeState> createEmp(EmployeeState employeeState);
}
