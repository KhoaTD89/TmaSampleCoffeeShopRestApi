package com.tma.sample.coffeeshop.security.service;

import com.tma.sample.coffeeshop.security.model.User;
import com.tma.sample.coffeeshop.security.repo.UserRepository;
import com.tma.sample.coffeeshop.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user){
        try {
            userRepository.save(user);
        }catch(Exception e){
            throw new ResourceNotFoundException("will change later");
        }
    }
}
