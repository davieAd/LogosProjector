package com.example.logosproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class LogosProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogosProjectApplication.class, args);
    }

}
