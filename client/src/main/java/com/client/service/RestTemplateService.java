package com.client.service;

import com.client.dto.UserRequest;
import com.client.dto.UserResponse;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "aaaa")
                .queryParam("age", 10)
                .encode()
                .build()
                .toUri();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
        return result.getBody();
    }

    public UserResponse post(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        return response.getBody();
    }
}
