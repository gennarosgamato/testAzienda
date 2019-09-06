package com.azienda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AziendaApplication {
	
	private static final Logger logger = LogManager.getLogger(AziendaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AziendaApplication.class, args);
    }
}
