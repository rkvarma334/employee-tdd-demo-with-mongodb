package com.app.employeetddexample.email.model;

public class EmailData {
    private String fromAddress;
    private String subject;
    private String message;



    public String getFromAddress() {
        return fromAddress;
    }
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }



    public String sendOtp(String emailId){

        if (this.getFromAddress().equals(emailId)){

        }
        return "";
    }
}
