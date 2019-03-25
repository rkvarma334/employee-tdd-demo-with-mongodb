package com.app.employeetddexample.employee.model;

import java.time.LocalDateTime;

public class EmployeeState {

    private String empId;
    private String empName;
    private String mobileNum;
    private String emailId;
    private LocalDateTime empCreatedDate;


    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getMobileNum() {
        return mobileNum;
    }
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDateTime getEmpCreatedDate() {
        return empCreatedDate;
    }
    public void setEmpCreatedDate(LocalDateTime empCreatedDate) {
        this.empCreatedDate = empCreatedDate;
    }




}
