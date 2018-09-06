package com.ubs.greenheroes;

import com.ubs.greenheroes.generate.MockedDataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreenheroesApplication {

    public static void main(String[] args) {
        MockedDataGenerator.createMockedInstruments();
        MockedDataGenerator.createMockedClient();
        SpringApplication.run(GreenheroesApplication.class, args);
    }
}
