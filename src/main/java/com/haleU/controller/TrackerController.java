package com.haleU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TrackerController {

    @RequestMapping("/welcome")
    public String Welcome() {
        return "welcomepage";
    }
}
