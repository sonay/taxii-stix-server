package com.example;

import com.example.stix.serialization.jackson.config.StixObjectsModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TaxiiStixServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxiiStixServerApplication.class);
    }

    @Bean
    public StixObjectsModule stixSerialization() {
        return new StixObjectsModule();
    }

    @Bean
    public JavaTimeModule javaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(ZonedDateTime.class,
                new ZonedDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        return module;
    }

}
