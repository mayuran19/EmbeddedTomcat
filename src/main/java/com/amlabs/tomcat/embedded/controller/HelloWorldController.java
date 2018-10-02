package com.amlabs.tomcat.embedded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageChannel ordersChannel;
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring 5 and embedded Tomcat 8!";
    }
}
