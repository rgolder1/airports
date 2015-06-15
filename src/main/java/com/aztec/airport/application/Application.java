package com.aztec.airport.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Spring Boot Application.
 *
 * @author robertgolder
 */
@SpringBootApplication
@ComponentScan({"com.aztec.airport"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
