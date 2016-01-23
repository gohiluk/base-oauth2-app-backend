package com.tnosal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;

@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@SpringBootApplication
public class DziennikKosztowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DziennikKosztowApplication.class, args);
    }
}
