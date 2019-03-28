package com.app.employeetddexample.otp.model;

import java.time.LocalDateTime;

public class OtpState {


    private String otpId;
    private String otp;
    private LocalDateTime createTime;
    private LocalDateTime validateTime;
    private OtpStatus otpStatus;
    private OTPType otpType;
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public OTPType getOtpType() {
        return otpType;
    }
    public void setOtpType(OTPType otpType) {
        this.otpType = otpType;
    }

    public String getOtpId() {
        return otpId;
    }
    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }
    public String getOtp() {
        return otp;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }

    public OtpStatus getOtpStatus() {
        return otpStatus;
    }
    public void setOtpStatus(OtpStatus otpStatus) {
        this.otpStatus = otpStatus;
    }


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(LocalDateTime validateTime) {
        this.validateTime = validateTime;
    }
}
