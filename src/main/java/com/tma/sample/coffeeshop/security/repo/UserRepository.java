package com.tma.sample.coffeeshop.security.repo;

import com.tma.sample.coffeeshop.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
