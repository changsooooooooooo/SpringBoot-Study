package com.validations.controller;

import com.validations.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public Object user(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(
                    x->{
                        FieldError field = (FieldError) x;
                        String message = field.getDefaultMessage();
                        System.out.println("field : "+field.getField());
                        System.out.println(message);

                        sb.append("field : ").append(field.getField());
                        sb.append("message: ").append(message);
                    }
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        System.out.println(user);
        return user;
    }
}
