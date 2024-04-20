package com.damin.shoppingmall.repository;

import com.damin.shoppingmall.model.Heart;
import com.damin.shoppingmall.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeartMapper {
	Heart selectHeartByProdId(Long prodId);
	void insertHeart(Heart heart);

	void deleteHeart(Long prodId);

	List<Heart> selectAllHeartByMemberId(Long memberId);
}