package com.example.start.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiController {
    @RequestLimit
    @GetMapping("/api")
    public void api() {
        log.info("Успешно");
    }
}
