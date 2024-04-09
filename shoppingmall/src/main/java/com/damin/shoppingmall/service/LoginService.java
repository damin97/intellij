package com.damin.shoppingmall.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damin.shoppingmall.model.Member;
import com.damin.shoppingmall.repository.MemberMapper;

@Service
public class LoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	HttpSession httpSession;
	
	public Member login(String userId, String pw) {
		Member member = memberMapper.loginCheck(userId);
		System.out.println(member);
		
		if(member != null && member.getUserId().equals(userId) && member.getPw().equals(pw)) {
			httpSession.setAttribute("loginMember", member);
			System.out.println("로그인 성공");
			return member;
		} 
	return null;
	}
	public void logout() {
		httpSession.removeAttribute("loginMember");
	}
}
