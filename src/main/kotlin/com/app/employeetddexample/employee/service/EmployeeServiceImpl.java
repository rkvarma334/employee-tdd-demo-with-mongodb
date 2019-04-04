package com.app.employeetddexample.employee.service;

import com.app.employeetddexample.email.model.EmailData;
import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeList;
import com.app.employeetddexample.employee.model.EmployeeState;
import com.app.employeetddexample.employee.model.ForgotPassword;
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
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;



/*

    @Autowired
    private MailPublisher mailPublisher;
*/


    @Autowired
    private IOTPService iotpService;

    @Override
    public Either<Exception,String> createEmployee(EmployeeState employeeState) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
    public Either<Exception, String> updateForgotPassword(ForgotPassword forgotPassword) {

       EmployeeState employeeState= employeeRepo.
               findByMobileNumOrUsername(forgotPassword.getUserNameOrMobileNumber());


        if (forgotPassword.getUserNameOrMobileNumber().equals(employeeState.getMobileNum()) ||
                forgotPassword.getUserNameOrMobileNumber().equals(employeeState.getUsername()))
        {

            OtpModel otpModel = new OtpModel();
            if (otpModel.getOtpState().getOtpType().equals(OTPType.FORGOT_PASSWORD))
            {
              OtpState otpState = otpModel.generateOTP(forgotPassword.getUserNameOrMobileNumber());

                iotpService.saveOtp(otpState);
              /*  EmailData emailData = new EmailData();
                emailData.setSubject("OTP");
                emailData.setMessage("Please don't share 6 digits OTP with any one "+otpState.getOtp());
                emailData.setFromAddress(employeeState.getEmailId());
               mailPublisher.sendMessageToEmail(emailData);*/
                return Either.right("OTP send to mail Id");
            }

        }
         return Either.left(new Exception("Invalid username or Mobile Number"));
    }

}
