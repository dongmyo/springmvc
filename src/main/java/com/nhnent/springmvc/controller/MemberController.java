package com.nhnent.springmvc.controller;

import com.nhnent.springmvc.model.Member;
import com.nhnent.springmvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
    @Autowired
    MemberRepository memberRepository;


    @GetMapping(value = "/list")
    public ModelAndView list() {
        List<Member> members = memberRepository.list();

        ModelAndView mav = new ModelAndView("member/list");
        mav.addObject("members", members);

        return mav;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") String id) {
        return getMember(id);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, params = "id")
    public ModelAndView detail2(@RequestParam("id") String id) {
        return getMember(id);
    }

    private ModelAndView getMember(String id) {
        Member member = memberRepository.get(id);

        return new ModelAndView("member/detail")
                .addObject("detail", member);
    }

}
