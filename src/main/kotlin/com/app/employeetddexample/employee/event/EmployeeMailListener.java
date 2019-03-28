package com.app.employeetddexample.employee.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMailListener {


    @Autowired
    EmployeeInputStream employeeInputStream;

    @StreamListener(EmployeeInputStream.INPUT)
    public void listener(@Payload EmailData emailData)
    {

    }
}
