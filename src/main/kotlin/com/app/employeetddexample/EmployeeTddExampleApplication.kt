package com.app.employeetddexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
/*@EnableBinding(MailPublisher::class,
               EmployeeInputStream::class)*/
class EmployeeTddExampleApplication

fun main(args: Array<String>) {
    runApplication<EmployeeTddExampleApplication>(*args)
}
