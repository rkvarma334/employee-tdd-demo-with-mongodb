package com.app.employeetddexample.otp.model;

import java.time.LocalDateTime;
import java.util.UUID;



public class OtpModel {

    private OtpState otpState;

    public OtpState getOtpState() {
        return otpState;
    }

    public void setOtpState(OtpState otpState) {
        this.otpState = otpState;
    }

    public OtpState generateOTP( String emailId){
        OtpState otpState = new OtpState();
        OtpGenerator otpGenerator = new OtpGenerator();
        otpState.setEmailId(emailId);
        otpState.setOtpId(UUID.randomUUID().toString());
        otpState.setOtp(otpGenerator.generateRandomString());
        otpState.setCreateTime(LocalDateTime.now());
        otpState.setValidateTime(LocalDateTime.now().plusMinutes(15));
        otpState.setOtpStatus(OtpStatus.ACTIVE);
        return otpState;
    }


}
