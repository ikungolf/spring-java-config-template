package com.github.ikungolf.springjava.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public String sayHello() {
        String hello = "Hello World";
        return hello;
    }
}
