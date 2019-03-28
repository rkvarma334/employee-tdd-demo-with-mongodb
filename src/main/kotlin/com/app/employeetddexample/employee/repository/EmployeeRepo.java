package com.app.employeetddexample.employee.repository;

import com.app.employeetddexample.employee.model.Employee;
import com.app.employeetddexample.employee.model.EmployeeState;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<EmployeeState, String> {

     Employee findByEmpId(String empId);

   EmployeeState findByMobileNumOrUsername(String MobileNumOrUserName);


}
