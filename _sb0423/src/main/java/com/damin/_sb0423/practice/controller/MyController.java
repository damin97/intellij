package com.damin._sb0423.practice.controller;

import com.damin._sb0423.practice.dto.InputRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/practice")
public class MyController {

    @GetMapping
    public String form(Model model) {
        model.addAttribute("inputRequest", new InputRequest());
        return "practice/form";
    }

    @PostMapping
    public String result(@Valid InputRequest inputRequest, Errors errors) {
        if(errors.hasErrors()) {
            return "practice/form";
        }
        return "practice/result";
    }
}
