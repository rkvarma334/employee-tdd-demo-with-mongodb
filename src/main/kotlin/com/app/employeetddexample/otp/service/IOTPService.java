package com.app.employeetddexample.otp.service;


import com.app.employeetddexample.otp.model.OtpModel;
import com.app.employeetddexample.otp.model.OtpState;

import java.util.List;

public interface IOTPService {

    String saveOtp(OtpState otpState);

    List<OtpState> getAllOtps();

}
