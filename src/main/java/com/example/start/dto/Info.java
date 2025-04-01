package com.example.start.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Date;

@Data
public class Info {
    @JsonProperty
    private Long id;
    @JsonProperty
    private Date date;

    public Info withId(Long id) {
        this.id = id;
        return this;
    }
}
