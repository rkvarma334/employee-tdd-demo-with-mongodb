package com.app.employeetddexample;

import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeList;
import com.app.employeetddexample.employee.model.EmployeeState;
import com.app.employeetddexample.employee.model.IEmployeeList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    private IEmployeeList iEmployeeList;


@Before
    public void init(){

    EmployeeState employeeState = new EmployeeState();
    Employee employee = new Employee(employeeState);
    employeeState.setMobileNum("9000125172");
    employeeState.setEmailId("ramesh@gmail.com");

    EmployeeState employeeState1 = new EmployeeState();
    Employee employee1 = new Employee(employeeState1);
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
    employeeState.setEmpId("12345");
    employeeState.setMobileNum("9000125172");




    }




    @Test
    public void createEmpTestFail(){

    EmployeeState newEmployeeState = new EmployeeState();
    newEmployeeState.setMobileNum("9000125172");
    newEmployeeState.setEmailId("ramesh@gmail.com");

   Boolean b = iEmployeeList.createEmployee(newEmployeeState);

        Assert.assertFalse(b);

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

        Boolean b = iEmployeeList.createEmployee(newEmployeeState);

        Assert.assertTrue(b);

    }


}
