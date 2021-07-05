package com.exceptionhandle.controller;

import com.exceptionhandle.dto.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min=2)
            @RequestParam String name,

            @NotNull
            @Min(1)
            @RequestParam Integer age){
        int a = age+10;
        return new User(name, age);
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user){
        return user;
    }
}
