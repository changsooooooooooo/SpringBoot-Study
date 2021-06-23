package com.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/", method= RequestMethod.GET)
public class HelloWorldController {

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String defaultPage(){
        return "HelloWorld";
    }
}
