package com.damin.chap11mvc1.repository;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAnswerDao {

    @Select("select count(*) from answer")
    int countAnswer();
    @Select("select * from answer")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "age", column = "age"),
            @Result(property = "name", column = "name"),
            @Result(property = "dataList", javaType = List.class, column = "id", many = @Many(select = "getByAnswerId"))
    })
    List<AnswerDto> getAll();

    @Select("select * from answer_data where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "dataList", column = "data_list"),
            @Result(property = "seq", column = "seq")
    })
    List<AnswerData> getByAnswerId(@Param("id") Long id);
}
