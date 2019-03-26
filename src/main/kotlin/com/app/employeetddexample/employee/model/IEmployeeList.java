package com.app.employeetddexample.employee.model;


import io.vavr.control.Either;

public interface IEmployeeList {

    Either<Exception,Boolean> createEmp(EmployeeState employeeState);

}
