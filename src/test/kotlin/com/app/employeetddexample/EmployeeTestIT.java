package com.app.employeetddexample;

import com.app.employeetddexample.employee.model.EmployeeState;
import com.app.employeetddexample.employee.model.ForgotPassword;
import com.app.employeetddexample.employee.model.VerifyOTP;
import com.app.employeetddexample.employee.service.IEmployeeService;
import io.vavr.control.Either;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTestIT {

@Autowired
    private IEmployeeService iEmployeeService;

   @Test
   public void createEmpTestPass(){

       EmployeeState employeeState = new EmployeeState();
       employeeState.setEmpId("423456789");
       employeeState.setUsername("Raj223");
       employeeState.setPassword("password");
       employeeState.setEmpName("RajMahendra");
       employeeState.setMobileNum("9700125172");
       employeeState.setDob(LocalDateTime.now());
       employeeState.setEmailId("raj@gmail.com");
       employeeState.setEmpCreatedDate(LocalDateTime.now());
       Either either =  iEmployeeService.createEmployee(employeeState);

       System.out.println(either);
           Assert.assertTrue(either.isRight());
          // Assert.assertTrue(either.isRight());


       }


       @Test
    public void updatepassword(){

           ForgotPassword forgotPassword = new ForgotPassword();
           forgotPassword.setEmailId("raj@gmail.com");
           forgotPassword.setOtp("password");
           forgotPassword.setNewPassword("password123");
           Either either =  iEmployeeService.forgotPassword(forgotPassword);
           Assert.assertTrue(either.isRight());
       }

       @Test
    public void verifyOtpTest()
       {
           VerifyOTP verifyOTP = new VerifyOTP();
           verifyOTP.setEmailId("raj@gmail.com");
           verifyOTP.setOtp("400815");
           verifyOTP.setNewPassword("password12345");

           Either either = iEmployeeService.verifyOTP(verifyOTP);
           Assert.assertTrue(either.isRight());
       }

}
