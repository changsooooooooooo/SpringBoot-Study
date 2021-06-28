package com.springbootstudy.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    @DeleteMapping("/{userId}")
    public void deleteController(@PathVariable String userId, @RequestParam String account) {
        System.out.println(userId);
        System.out.println(account);
    }
}
