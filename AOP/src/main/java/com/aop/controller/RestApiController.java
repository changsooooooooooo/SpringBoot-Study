package com.aop.controller;

import com.aop.annotation.Decode;
import com.aop.annotation.Timer;
import com.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name){
        return id + ", "+name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
//        System.out.println("post method : "+user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        return user;
    }
}
