package com.microservices.userservice.controller;

import com.microservices.userservice.manager.UserManager;
import com.microservices.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserManager userManager;


    @GetMapping
    public User getUserById(@RequestParam("id") Long id) {
        return userManager.getUserById(id);

    }
}
