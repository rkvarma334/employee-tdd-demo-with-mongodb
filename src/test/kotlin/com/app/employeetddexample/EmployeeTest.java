package com.app.employeetddexample;

import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeList;
import com.app.employeetddexample.employee.model.EmployeeState;
import com.app.employeetddexample.employee.model.IEmployeeList;
import com.app.employeetddexample.employee.service.IEmployeeService;
import io.vavr.control.Either;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {

    private IEmployeeList iEmployeeList;

    @Autowired
    private IEmployeeService iEmployeeService;


@Before
    public void init(){

    EmployeeState employeeState = new EmployeeState();
    Employee employee = new Employee(employeeState);
    employeeState.setEmpId("123456");
    employeeState.setMobileNum("9000125172");
    employeeState.setEmailId("kumaravarma@gmail.com");
    employeeState.setEmpName("kumaravarma");

    EmployeeState employeeState1 = new EmployeeState();
    Employee employee1 = new Employee(employeeState1);
    employeeState1.setEmpId("1234567");
    employeeState1.setEmpName("ramesh");
    employeeState1.setMobileNum("9876543210");
    employeeState1.setEmailId("ramesh1@gmail.com");

    List<Employee> employeeList= new ArrayList<>();
    employeeList.add(employee);
    employeeList.add(employee1);


    iEmployeeList = new EmployeeList(employeeList);

}

    @Test
    public void createEmployeeTestFail(){
    EmployeeState employeeState = new EmployeeState();
    employeeState.setEmpId("123456");
    employeeState.setMobileNum("9000125172");

   Either either =  iEmployeeService.createEmployee(employeeState);

    Assert.assertTrue(either.isLeft());

    }

    @Test
    public void createEmployeeTestPass(){
        EmployeeState employeeState = new EmployeeState();
        employeeState.setEmpId("12345678");
        employeeState.setMobileNum("8000125172");

        Either either =  iEmployeeService.createEmployee(employeeState);

        Assert.assertTrue(either.isRight());

    }


    @Test
    public void createEmpTestFail(){

    EmployeeState newEmployeeState = new EmployeeState();
    newEmployeeState.setMobileNum("9000125172");
    newEmployeeState.setEmailId("ramesh@gmail.com");

   Either either = iEmployeeList.createEmp(newEmployeeState);

        Assert.assertTrue(either.isRight());

      /*
      Assert.assertNull(b);
      Initially with out initializing an object we will get Null Pointer Exception here

      * */
    }


    @Test
    public void createEmpTestPass(){

        EmployeeState newEmployeeState = new EmployeeState();
        newEmployeeState.setMobileNum("8179170688");
        newEmployeeState.setEmailId("stonecold@gmail.com");

       Either either = iEmployeeList.createEmp(newEmployeeState);

        Assert.assertTrue(either.isRight());

    }


}
