package com.app.employeetddexample;

import com.app.employeetddexample.employee.model.EmployeeState;
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
       employeeState.setMobileNum("4000125172");
       employeeState.setEmpName("Dasharath");
       employeeState.setEmailId("dasharath@gmail.com");
       employeeState.setEmpCreatedDate(LocalDateTime.now());

       Either either =  iEmployeeService.createEmployee(employeeState);

       System.out.println(either);
           Assert.assertTrue(either.isRight());
          // Assert.assertTrue(either.isRight());

       }


}
