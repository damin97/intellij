package com.damin._sb0408.controller;

import com.damin._sb0408.spring.MemberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberListService memberListService;

    @GetMapping("/memberList")
    public String showMemList(Model model) {
        model.addAttribute("memberList", memberListService.getMemberList());
        return "member/memberList";
    }
}
