package com.nhnent.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/login";
    }

}
