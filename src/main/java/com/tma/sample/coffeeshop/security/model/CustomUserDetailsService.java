package com.tma.sample.coffeeshop.security.model;

import com.tma.sample.coffeeshop.security.repo.UserRepository;
import com.tma.sample.coffeeshop.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new ResourceNotFoundException("email is notfound");
        }
        System.out.println("FOUND AN EMAIL");
        return new CustomUserDetails(user);
    }
}


//public class CustomUserDetailsService{}