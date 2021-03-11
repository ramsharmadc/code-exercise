package com.halodoc.campaign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouponsWebService {

    private static final Logger log = LoggerFactory.getLogger(CouponsWebService.class);

    public static void main(String[] args) {
        log.info("STARTING up application...");
        SpringApplication.run(CouponsWebService.class,args);
        log.info("Spring Boot application STARTED");
    }
}

