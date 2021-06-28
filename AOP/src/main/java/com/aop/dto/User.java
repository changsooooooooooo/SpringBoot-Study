package com.aop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class User {

    private String id;
    private String pw;
    private String email;

}
