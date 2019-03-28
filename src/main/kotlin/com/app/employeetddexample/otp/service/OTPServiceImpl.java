package com.app.employeetddexample.otp.service;

import com.app.employeetddexample.otp.model.OTPType;
import com.app.employeetddexample.otp.model.OtpGenerator;
import com.app.employeetddexample.otp.model.OtpModel;
import com.app.employeetddexample.otp.model.OtpState;
import com.app.employeetddexample.otp.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OTPServiceImpl implements IOTPService {


    @Autowired
    private OTPRepository otpRepository;

    @Override
    public String saveOtp(OtpState otpState) {
        otpRepository.save(otpState);
        return otpState.getOtpId();
    }

    @Override
    public List<OtpModel> getAllOtps() {
        return  otpRepository.findAll().stream().
                map(x->new OtpModel()).collect(Collectors.toList());
    }


}
