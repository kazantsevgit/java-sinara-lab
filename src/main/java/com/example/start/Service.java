package com.example.start;

import com.example.start.Model.User;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@org.springframework.stereotype.Service
@Validated
public class Service {

    public void register(@Valid User user) {
        save(user);
    }

    public void save(@Valid User user) {
        // Логика
    }
}
