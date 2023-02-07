package com.food.tacocloud.service;

import com.food.tacocloud.domain.User;
import com.food.tacocloud.repo.SpringJdbcUserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private SpringJdbcUserRepo userRepo;

    @Override
    public Long registerUser(User user) {
        log.info("Register user: {}", user);
        User registeredUser = userRepo.save(user);
        return registeredUser.getId();
    }
}
