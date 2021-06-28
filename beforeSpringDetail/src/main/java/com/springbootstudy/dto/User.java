package com.springbootstudy.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
}
