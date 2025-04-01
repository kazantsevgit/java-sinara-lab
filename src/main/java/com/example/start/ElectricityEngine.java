package com.example.start;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ElectricityEngine implements Engine {
    @PostConstruct
    public void init() {
        System.out.println("Создан");
    }

    @Override
    public void send() {
        System.out.println("ElectricityEngine is working");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Разрушен");
    }

    @Override
    public String getEngineType() {
        return "ElectricEngine";
    }
}
