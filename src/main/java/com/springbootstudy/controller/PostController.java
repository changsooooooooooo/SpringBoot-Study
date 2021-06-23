package com.springbootstudy.controller;

import com.springbootstudy.dto.PostRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping("post")
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("key : " + value);
        });
    }

    @PostMapping("post2")
    public void post2(@RequestBody PostRequestDTO postRequestDTO){
        System.out.println(postRequestDTO);
    }
}
