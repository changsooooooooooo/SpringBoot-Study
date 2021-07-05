package com.exceptionhandle.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Error {

    private String filed;
    private String message;
    private String invalidValue;
}
