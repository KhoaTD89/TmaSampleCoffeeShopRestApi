package com.tma.sample.coffeeshop;



import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class CoffeeShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
//        writeLog();
    }
    public static void writeLog(){
        log.trace("for tracing purpose");
        log.debug("for debugging purpose");
        log.info("for informational purpose");
        log.warn("for warning purpose");
        log.error("for logging errors");
    }

}
