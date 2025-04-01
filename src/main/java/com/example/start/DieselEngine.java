package com.example.start;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class DieselEngine implements Engine {
    @PostConstruct
    public void init() {
        System.out.println("Создан");
    }

    @Override
    public void send() {
        System.out.println("DieselEngine is working");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Разрушен");
    }

    @Override
    public String getEngineType() {
        return "DieselEngine";
    }
}
