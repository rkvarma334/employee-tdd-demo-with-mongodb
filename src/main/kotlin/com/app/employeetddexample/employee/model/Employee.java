package com.app.employeetddexample.employee.model;

public class Employee {

    private EmployeeState employeeState;
    public Employee(EmployeeState employeeState){
        this.employeeState=employeeState;
    }

    public EmployeeState getEmployeeState() {
        return employeeState;
    }
    public void setEmployeeState(EmployeeState employeeState) {
        this.employeeState = employeeState;
    }




    public String createEmployee(EmployeeState employeeState){

        this.employeeState.setEmpId(employeeState.getEmpId());
        this.employeeState.setEmpName(employeeState.getEmpName());
        this.employeeState.setEmailId(employeeState.getEmailId());
        this.employeeState.setMobileNum(employeeState.getMobileNum());

        return this.employeeState.getEmpId();
    }


    }

