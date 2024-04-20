package com.damin.chap11mvc1.repository;

import com.damin.chap11mvc1.spring.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IMemberDao {

    @Select("select count(*) from member")
    int countMember();

    @Select("select * from member where email = #{email}")
    public Member selectByEmail(String email);

    @Insert("insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (#{member.email}, #{member.password}, #{member.name}, #{member.regdate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(@Param("member") Member member);
}