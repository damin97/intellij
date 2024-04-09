package com.damin.shoppingmall.service;

import java.util.List;

import com.damin.shoppingmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damin.shoppingmall.model.Member;
import com.damin.shoppingmall.repository.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	public Member getMemberById(Long memberId) {

        return memberMapper.selectByMemberId(memberId);
    }

    public List<Member> getAllMembers() {

        return memberMapper.selectAllMember();
    }

    @Transactional
    public void addMember(Member member) {

        memberMapper.insertMember(member);
    }

    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }

    public int deleteMember(Long memberId) {

        return memberMapper.deleteMember(memberId);
    }
}
