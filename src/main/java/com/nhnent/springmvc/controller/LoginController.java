package com.nhnent.springmvc.controller;

import com.nhnent.springmvc.model.Member;
import com.nhnent.springmvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    MemberRepository memberRepository;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "login/form";
    }

    @PostMapping("/login")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(HttpSession session, Member loginInfo) {
        Member member = memberRepository.find(loginInfo.getId(), loginInfo.getPassword());
        if (member == null) {
            return "login/fail";
        }
        else {
            session.setAttribute("member", member);
            return "redirect:/member/list";
        }
    }

}
