package com.tma.sample.coffeeshop;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeShopApplication {
    private static final Logger LOGGER = LogManager.getLogger(CoffeeShopApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
    }
    public static void run(){
        LOGGER.trace("for tracing purpose");
        LOGGER.debug("for debugging purpose");
        LOGGER.info("for informational purpose");
        LOGGER.warn("for warning purpose");
        LOGGER.error("for logging errors");
    }

}
