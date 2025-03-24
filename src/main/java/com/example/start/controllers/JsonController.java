package com.example.start.controllers;

import com.example.start.dto.RequestDTO;
import com.example.start.dto.ResponseDTO;
import com.example.start.exception.GatewayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class JsonController {

    @PostMapping(value = "/process", consumes = "application/json")
    public ResponseDTO process(@RequestBody RequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        response.setPrice(request.getPrice());
        long newId = ThreadLocalRandom.current().nextLong(9, 1000);

        if (newId < 10) {
            throw new GatewayException("Failed to generate unique ID");
        }
        response.setInfo(request.getInfo().withId(newId));
        return response;
    }
}

