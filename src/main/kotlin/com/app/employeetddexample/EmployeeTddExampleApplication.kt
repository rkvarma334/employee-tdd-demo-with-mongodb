package com.app.employeetddexample

import com.app.employeetddexample.email.event.MailPublisher
import com.app.employeetddexample.employee.event.EmployeeInputStream
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
@EnableBinding(MailPublisher::class,
               EmployeeInputStream::class)
class EmployeeTddExampleApplication

fun main(args: Array<String>) {
    runApplication<EmployeeTddExampleApplication>(*args)
}
