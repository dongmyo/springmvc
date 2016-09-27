package com.nhnent.springmvc.controller;

import com.nhnent.springmvc.model.Member;
import com.nhnent.springmvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/member")
public class MemberListController {
    @Autowired
    MemberRepository memberRepository;


    @GetMapping(value = "/list")
    public String list(ModelMap map) {
        List<Member> members = memberRepository.list();

        map.addAttribute("members", members);

        return "member/list";
    }

}
