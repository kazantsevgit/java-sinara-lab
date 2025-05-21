package com.example.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Endpoint(id = "logtime")
public class LogTimeActuator {

    private static final Logger logger = LoggerFactory.getLogger(LogTimeActuator.class);

    @ReadOperation
    public String logTime() {
        String message = "[LOGTIME] Актуатор вызван: " + LocalDateTime.now();
        logger.info(message);
        return message;
    }
}

