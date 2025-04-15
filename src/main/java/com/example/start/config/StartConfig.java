package com.example.start.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "start-config")
@Data
public class StartConfig {
    private String name;
    private List<String> values;
}
