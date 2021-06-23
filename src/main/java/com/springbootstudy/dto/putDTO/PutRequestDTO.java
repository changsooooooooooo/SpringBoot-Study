package com.springbootstudy.dto.putDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PutRequestDTO {

    private String name;
    private int age;

    @JsonProperty("car_list")
    private List<CarDTO> carList;
}
