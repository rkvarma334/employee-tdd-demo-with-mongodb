package com.app.employeetddexample.otp.repository;

import com.app.employeetddexample.otp.model.OtpState;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends MongoRepository<OtpState, String> {

}
