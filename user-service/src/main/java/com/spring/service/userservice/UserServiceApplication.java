package com.spring.service.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class UserServiceApplication {



    public static void main(String[] args) {
        log.info("UserServiceApplication starting...");

        SpringApplication.run(UserServiceApplication.class, args);

    }
}
