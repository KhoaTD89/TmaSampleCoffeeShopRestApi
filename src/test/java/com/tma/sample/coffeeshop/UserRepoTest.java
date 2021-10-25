package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.security.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepoTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void testFindAddressByStoreId(){
        Assertions.assertNotNull(userRepository.findByEmail("fff"));
    }

}
