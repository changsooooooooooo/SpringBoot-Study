package com.server.controller;

import com.server.dto.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
@Log4j2
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){

        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user, @PathVariable int userId, @PathVariable String userName){
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("client req : {}", user);
        return user;
    }
}
