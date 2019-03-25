package com.app.employeetddexample.employee.service;

import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeState;

import java.util.List;

public interface IEmployeeService {

    String createEmployee(EmployeeState employeeState);
    Employee getEmpById(String empId);
    List<EmployeeState> getAllEmps();
}
