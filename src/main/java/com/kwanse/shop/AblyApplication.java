package com.kwanse.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class AblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AblyApplication.class, args);
    }

}
