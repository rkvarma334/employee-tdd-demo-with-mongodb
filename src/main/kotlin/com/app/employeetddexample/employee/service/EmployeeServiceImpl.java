package com.app.employeetddexample.employee.service;

import com.app.employeetddexample.email.event.MailPublisher;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private MailPublisher mailPublisher;



    @Autowired
    private IOTPService iotpService;

    @Override
    public Either<Exception,String> createEmployee(EmployeeState employeeState) {

       List<Employee> oldEmpList =   this.getAllEmps();
        EmployeeList oldEmployeeList = new EmployeeList(oldEmpList);
     Either either=   oldEmployeeList.createEmp(employeeState);
        if (either.isRight()){
            employeeRepo.save(employeeState);
            return Either.right(employeeState.getEmpId());
        }
        return Either.left(new Exception("emp registered already"));
    }

    @Override
    public List<Employee> getAllEmps() {

       List<EmployeeState> employeeStateList= employeeRepo.findAll();

      List<Employee> employeeList = employeeStateList.stream().map( x->new Employee(x)).collect(Collectors.toList());

        return employeeList;
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
              OtpState otpState= otpModel.generateOTP(forgotPassword.getUserNameOrMobileNumber());

                iotpService.saveOtp(otpState);
                EmailData emailData = new EmailData();
                emailData.setSubject("OTP");
                emailData.setMessage("Please Dont share with any one"+otpState.getOtp());
                emailData.setFromAddress(employeeState.getEmailId());
               mailPublisher.sendMessageToEmail(emailData);
                return Either.right("OTP send to mail Id");
            }

        }
         return Either.left(new Exception("Invalid username or Mobile Number"));
    }


}
