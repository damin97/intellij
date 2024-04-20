package com.damin.chap11mvc1.repository;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AnswerData {
    private Long id;
    private String dataList;
    private int seq;
}
