package com.kwanse.ably;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class AblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AblyApplication.class, args);
    }

}
