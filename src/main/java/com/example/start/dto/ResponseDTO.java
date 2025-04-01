package com.example.start.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ResponseDTO {
    @JsonProperty
    private Double price;
    @JsonProperty
    private Info info;
}
