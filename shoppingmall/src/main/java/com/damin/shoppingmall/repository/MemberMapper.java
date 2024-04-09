package com.damin.shoppingmall.repository;

import java.util.List;

import com.damin.shoppingmall.model.Member;
import com.damin.shoppingmall.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberMapper {
	
	@Select("select count(*) from member")
	int count();
	
	Member selectByMemberId(Long memberId);
	
	@Select("select * from member")
	List<Member> selectAllMember();
	
	void insertMember(Member member);

	void updateMember(Member member);

	int deleteMember(Long memberId);
	
	Member loginCheck(String userId);

	Member selectByUserId(String userId);
}