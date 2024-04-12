package com.haleU.controller;

import com.haleU.model.User;
import com.haleU.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/")
    public String Hello() {
        return "Hello From HaleU";
    }

    @GetMapping("/save-user")
    public String saveUser(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        userService.saveMyUser(user);
        return "User Saved";
    }

}
