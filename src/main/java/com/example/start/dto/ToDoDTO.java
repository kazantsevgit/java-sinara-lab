package com.example.start.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class ToDoDTO {
    private String name;
    private List<String> events;
}