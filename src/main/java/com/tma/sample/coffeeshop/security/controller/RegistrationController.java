package com.tma.sample.coffeeshop.security.controller;


import com.tma.sample.coffeeshop.security.service.UserService;
import com.tma.sample.coffeeshop.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class RegistrationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @PostMapping("/customer/register")
    public void addCustomer(@RequestBody User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        System.out.println("saved");
    }

    @PostMapping("/admin/register")
    public void addAdmin(@RequestBody User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.save(user);
        System.out.println("saved");
    }
}
