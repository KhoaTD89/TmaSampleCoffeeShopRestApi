package com.tma.sample.coffeeshop;



import com.tma.sample.coffeeshop.domain.User;
import com.tma.sample.coffeeshop.domain.UserRepository;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@Log4j2
public class CoffeeShopApplication implements CommandLineRunner {

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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("khoa");
            user.setPassword(passwordEncoder.encode("khoa"));

        userRepository.save(user);
        System.out.println(user);
    }
}
