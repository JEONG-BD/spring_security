package com.example.w04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@ComponentScan("com.example.w04.controller")
@SpringBootApplication
@EnableJpaRepositories("com.example.w04.repository")
@EnableWebSecurity
@EntityScan("com.example.w04")
public class W04Application {

    public static void main(String[] args) {
        SpringApplication.run(W04Application.class, args);
    }

}
