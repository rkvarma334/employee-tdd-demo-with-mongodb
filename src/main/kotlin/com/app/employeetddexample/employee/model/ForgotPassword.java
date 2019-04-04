package com.app.employeetddexample.employee.model;

public class ForgotPassword {

    private String emailId;
    private String otp;
    private String newPassword;

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}
