package com.example.start.controller;

import com.example.start.dto.ToDoDTO;
import com.example.start.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService todoService;

    @Autowired
    public ToDoController (ToDoService service) {
        this.todoService = service;
    }

    @GetMapping("/get")
    public List<ToDoDTO> getList() {
        return todoService.getAllLists();
    }

    @PostMapping("/post")
    public void createList (ToDoDTO toDoDTO) {
        todoService.createList(toDoDTO);
    }
}
