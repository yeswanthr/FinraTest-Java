package com.finra.test.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.finra.test")
public class FinraTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinraTestApplication.class, args);
    }

}
