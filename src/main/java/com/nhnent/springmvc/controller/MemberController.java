package com.nhnent.springmvc.controller;

import com.nhnent.springmvc.model.Member;
import com.nhnent.springmvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    @Autowired
    MemberRepository memberRepository;


    @GetMapping(value = "/list")
    public String list(ModelMap map) {
        List<Member> members = memberRepository.list();

        map.addAttribute("members", members);

        return "member/list";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") String id) {
        Member member = memberRepository.get(id);

        return new ModelAndView("member/detail")
                .addObject("detail", member);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, params = "id")
    public String detail2(@RequestParam("id") String id, Model model) {
        Member member = memberRepository.get(id);

        model.addAttribute("detail", member);

        return "member/detail";
    }

}
