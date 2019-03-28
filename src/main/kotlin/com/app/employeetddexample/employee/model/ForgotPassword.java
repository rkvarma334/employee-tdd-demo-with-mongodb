package com.app.employeetddexample.employee.model;

public class ForgotPassword {

    private String userNameOrMobileNumber;
    private String oldPassword;
    private String newPassword;

    public String getUserNameOrMobileNumber() {
        return userNameOrMobileNumber;
    }

    public void setUserNameOrMobileNumber(String userNameOrMobileNumber) {
        this.userNameOrMobileNumber = userNameOrMobileNumber;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
