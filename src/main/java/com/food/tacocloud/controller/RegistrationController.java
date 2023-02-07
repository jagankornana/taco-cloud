package com.food.tacocloud.controller;

import com.food.tacocloud.domain.RegistrationForm;
import com.food.tacocloud.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/taco/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegistrationForm registrationForm) {
        log.info("User registration form request: {}", registrationForm);
        Long userId = registrationService.registerUser(registrationForm.toUser());
        return new ResponseEntity<>("UserId: " + userId, HttpStatus.CREATED);
    }
}
