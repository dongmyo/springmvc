package com.nhnent.springmvc.controller;

import com.nhnent.springmvc.exception.MemberNotFoundException;
import com.nhnent.springmvc.model.Member;
import com.nhnent.springmvc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/detail")
public class MemberDetailController {
    @Autowired
    MemberRepository memberRepository;


    @ModelAttribute("detail")
    public Member getMember(@PathVariable("id") String id) {
        Member member = memberRepository.get(id);
        if (member == null) {
            throw new MemberNotFoundException();
        }

        return member;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@ModelAttribute("detail") Member member) {
        return new ModelAndView("member/detail")
                .addObject("detail", member);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, params = "hiddenPassword")
    public ModelAndView detail2(@ModelAttribute("detail") Member member) {
        Member filteredMember = new Member();
        filteredMember.setId(member.getId());
        filteredMember.setPassword("*****");

        return new ModelAndView("member/detail")
                .addObject("detail", filteredMember);
    }

}
