package com.app.employeetddexample.employee.model;

import java.time.LocalDateTime;

public class EmployeeState {

    private String empId;
    private String empName;
    private String username;
    private String password;
    private String mobileNum;
    private String emailId;
    private LocalDateTime empCreatedDate;
    private LocalDateTime dob;



    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public LocalDateTime getDob() { return dob; }
    public void setDob(LocalDateTime dob) { this.dob = dob; }
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
