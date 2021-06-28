package com.springbootstudy.controller;

import com.springbootstudy.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/api/get", method= RequestMethod.GET)
public class HelloWorldController {

    @GetMapping(path="hello")
    public String getHello(){
        return "get Hello";
    }

    @GetMapping(path="path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : "+name);
        return name;
    }

//    @GetMapping(path="path-variable/{name}")
//    public String pathVariableV2(@PathVariable(name="name") String pathName){
//        System.out.println("PathVariable : "+pathName);
//        return pathName;
//    }

    @GetMapping(path="query-param")
    public String queryParameterGet(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println();

            sb.append(entry.getKey()+" = "+entry.getValue());
        });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email +" "+age;
    }

    @GetMapping("query-param03")
    public String queryParam3(UserRequest userRequest){
        return userRequest.toString();
    }
}
