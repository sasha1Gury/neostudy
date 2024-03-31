package ru.neostudy.vacationcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VacationCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationCalculatorApplication.class, args);
    }

}
