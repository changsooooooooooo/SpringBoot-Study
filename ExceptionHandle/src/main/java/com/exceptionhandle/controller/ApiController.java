package com.exceptionhandle.controller;

import com.exceptionhandle.dto.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class ApiController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age){
        int a = age+10;
        return new User(name, age);
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        return user;
    }
}
