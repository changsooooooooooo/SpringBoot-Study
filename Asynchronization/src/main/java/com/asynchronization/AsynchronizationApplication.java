package com.asynchronization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsynchronizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronizationApplication.class, args);
    }

}
