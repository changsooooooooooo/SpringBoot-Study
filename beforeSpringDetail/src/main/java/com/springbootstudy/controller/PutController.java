package com.springbootstudy.controller;

import com.springbootstudy.dto.putDTO.PutRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutController {

    @RequestMapping(value="putTest", method= RequestMethod.POST)
    public PutRequestDTO put(@RequestBody PutRequestDTO putRequestDTO){
        System.out.println(putRequestDTO);
        return putRequestDTO;
    }
}
