package com.haleU.controller;

import com.haleU.model.User;
import com.haleU.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrackerController {

    @Autowired
    private UserService userService;

    @RequestMapping("/welcome")
    public String Welcome(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "welcomepage";
    }

    @RequestMapping("/register")
    public String registration(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_REGISTER");
        return "welcomepage";
    }

    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        bindingResult.rejectValue("id", "primary-key");
        System.out.println(user.getUsername());
        userService.saveMyUser(user);
        request.setAttribute("mode", "MODE_HOME");
        return "welcomepage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "welcomepage";
    }

    @RequestMapping("/login-user")
    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
        if (userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
            return "homepage";
        }
        else {
            request.setAttribute("error", "Invalid username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "welcomepage";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "welcomepage";
    }

}
