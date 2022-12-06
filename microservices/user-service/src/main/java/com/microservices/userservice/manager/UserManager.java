package com.microservices.userservice.manager;

import com.microservices.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

    public User getUserById(Long id) {
       User user = new User();
       user.setId(id);
       user.setName("UserName1");
       return user;
    }
}
