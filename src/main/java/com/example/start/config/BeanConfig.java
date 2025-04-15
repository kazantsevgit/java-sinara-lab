package com.example.start.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class BeanConfig {

    @Bean
    @Profile("test")
    public String test() {
        log.info("TestBean is created");
        return "TestBean";
    }

    @Bean
    @ConditionalOnBean(name = "test")
    public String dependBean() {
        log.info("DependBean is created");
        return "DependBean";
    }

    @Bean
    @ConditionalOnExpression("#{'${start-config.env_var}' != 'default'}")
    public String expressionBean() {
        log.info("ExpressionBean is created, ENV_VAR IS NOT DEFAULT");
        return "ExpressionBean";
    }
}
