package it.academy.booking.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "it.academy.booking.tourist")
public class SpringBootInitialization {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootInitialization.class, args);
    }
}
