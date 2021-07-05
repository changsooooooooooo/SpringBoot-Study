package com.exceptionhandle.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@ToString
@AllArgsConstructor
public class User {

    @NotEmpty
    @Size(min=1, max = 10)
    private String name;

    @Min(1)
    @NotNull
    private Integer age;
}
