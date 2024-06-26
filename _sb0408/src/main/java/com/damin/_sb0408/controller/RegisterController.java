package com.damin._sb0408.controller;

import com.damin._sb0408.spring.DuplicateMemberException;
import com.damin._sb0408.spring.MemberRegisterService;
import com.damin._sb0408.spring.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private MemberRegisterService memberRegisterService;

	@RequestMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			System.out.println("DuplicateMemberException 발생!!!");
			return "register/step2";
		}
	}

	@ModelAttribute
	public void case1(Model model) {
		model.addAttribute("value1", "환영합니다");
	}

	@ModelAttribute("value2")
	public String case2() {
		return "다민입니다";
	}

}
