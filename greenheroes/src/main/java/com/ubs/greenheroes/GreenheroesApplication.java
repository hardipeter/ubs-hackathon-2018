package com.ubs.greenheroes;

import com.ubs.greenheroes.generate.MockedDataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class GreenheroesApplication {

    public static void main(String[] args) throws FileNotFoundException {
        MockedDataGenerator.createMockedInstruments();
        MockedDataGenerator.createMockedClient();
        SpringApplication.run(GreenheroesApplication.class, args);
    }
}
