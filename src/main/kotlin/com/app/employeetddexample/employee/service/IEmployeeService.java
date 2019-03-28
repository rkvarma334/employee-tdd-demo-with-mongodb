package com.app.employeetddexample.employee.service;

import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeState;
import com.app.employeetddexample.employee.model.ForgotPassword;
import io.vavr.control.Either;

import java.util.List;


public interface IEmployeeService {

    Either<Exception, String> createEmployee(EmployeeState employeeState);

    List<Employee> getAllEmps();

    Employee getEmpById(String empId);

    Either<Exception,String> updateForgotPassword(ForgotPassword forgotPassword);

}
