package com.app.employeetddexample.employee.service;

import com.app.employeetddexample.employee.model.*;
import com.app.employeetddexample.employee.repository.EmployeeRepo;
import com.app.employeetddexample.otp.model.OTPType;
import com.app.employeetddexample.otp.model.OtpModel;
import com.app.employeetddexample.otp.model.OtpState;
import com.app.employeetddexample.otp.service.IOTPService;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


/*

    @Autowired
    private MailPublisher mailPublisher;
*/


    @Autowired
    private IOTPService iotpService;

    @Override
    public Either<Exception,String> createEmployee(EmployeeState employeeState) {


       List<Employee> oldEmpList =   this.getAllEmps();


       if (oldEmpList.isEmpty()){
           Employee employee = new Employee(employeeState);
          String pssw= encoder.encode(employeeState.getPassword());
           EmployeeState employeeState1=employee.createEmployee(employeeState);
           employeeState1.setPassword(pssw);
           employeeRepo.save(employeeState1);
           return Either.right(employeeState1.getEmpId());
       }

        EmployeeList oldEmployeeList = new EmployeeList(oldEmpList);
        Either either=   oldEmployeeList.createEmp(employeeState);
        if (either.isRight()){
            String pass= encoder.encode(employeeState.getPassword());
            employeeState.setPassword(pass);
            employeeRepo.save(employeeState);
            return Either.right(employeeState.getEmpId());
        }
        return Either.left(new Exception("emp registered already"));
    }

    @Override
    public List<Employee> getAllEmps() {

        return employeeRepo.findAll().stream().map( x->new Employee(x)).collect(Collectors.toList());
    }


    @Override
    public Employee getEmpById(String empId) {

       Employee emp= employeeRepo.findByEmpId(empId);
        return emp;
    }



    @Override
    public Either<Exception, String> forgotPassword(ForgotPassword forgotPassword) {


       EmployeeState employeeState =employeeRepo.findByEmailId(forgotPassword.getEmailId());

       if (employeeState==null){
           return Either.left(new Exception("Invalid Email Id entered"));
       }

       OtpState otpState = new OtpState();
       OtpModel otpModel = new OtpModel();
       otpModel.setOtpState(otpState);

       OtpState otpState1 =otpModel.generateOTP(forgotPassword.getEmailId());
       otpState1.setOtpType(OTPType.FORGOT_PASSWORD);

       if (otpState1.getOtpType().equals(OTPType.FORGOT_PASSWORD)){

                iotpService.saveOtp(otpState1);
              /*  EmailData emailData = new EmailData();
                emailData.setSubject("OTP");
                emailData.setMessage("Please don't share 6 digits OTP with any one "+otpState.getOtp());
                emailData.setFromAddress(employeeState.getEmailId());
               mailPublisher.sendMessageToEmail(emailData);*/
                return Either.right("OTP send to mail Id");
            }
       return Either.left(new Exception("Some thing went wrong"));

    }

    @Override
    public Either<Exception, String> verifyOTP(VerifyOTP verifyOTP) {

      List<OtpState> otpModelList=  iotpService.getAllOtps();
      if (otpModelList==null)
      {
          return Either.left(new Exception("OTP is not generated"));
      }
     Optional<OtpState> otpStateOptional= otpModelList.stream().
              filter(x->x.getOtpType().compareTo(OTPType.FORGOT_PASSWORD)==0).
              filter(x->x.getOtp().compareTo(verifyOTP.getOtp())==0).findAny();

      if (otpStateOptional.isPresent()){

          EmployeeState employeeState = employeeRepo.
                  findByEmailId(verifyOTP.getEmailId());

          String newPass = encoder.encode(verifyOTP.getNewPassword());

          employeeState.setPassword(newPass);

          employeeRepo.save(employeeState);

          return Either.right("OTP is Verified");
      }

        return Either.left(new Exception("Some thing went wrong"));
    }


}
