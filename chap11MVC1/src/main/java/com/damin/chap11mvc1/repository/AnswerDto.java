package com.damin.chap11mvc1.repository;

import com.damin.chap11mvc1.survey.AnsweredData;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AnswerDto {
    private Long id;
    private List<AnswerData> dataList;
    private int age;
    private String name;
}
