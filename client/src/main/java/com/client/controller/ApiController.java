package com.client.controller;

import com.client.dto.UserResponse;
import com.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("/hello")
    public UserResponse getHello(){
        return restTemplateService.post();
    }
}
