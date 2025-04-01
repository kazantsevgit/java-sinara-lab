package com.example.start.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class RequestDTO {
    @JsonProperty
    private Info info;
    @JsonProperty
    private Double price;

}
