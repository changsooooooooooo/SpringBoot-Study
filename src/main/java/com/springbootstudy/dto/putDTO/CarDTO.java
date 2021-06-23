package com.springbootstudy.dto.putDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarDTO {
    private String name;

    @JsonProperty("car_number")
    private String carNumber;
}
