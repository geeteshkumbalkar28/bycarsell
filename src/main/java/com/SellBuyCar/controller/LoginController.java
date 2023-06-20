package com.SellBuyCar.controller;

import com.SellBuyCar.model.User;
import com.SellBuyCar.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/login")
    public User getUserDetailsAfterLogin(Principal user) {
        List<User> customers = userRepo.findByEmail(user.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        } else {
            return null;
        }
    }

}

