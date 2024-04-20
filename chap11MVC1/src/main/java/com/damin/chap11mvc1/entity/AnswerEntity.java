package com.damin.chap11mvc1.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @OrderColumn(name = "seq")
    @CollectionTable(name = "answer_data", joinColumns = @JoinColumn(name = "id"))
    private List<String> dataList;
    private int age;
    private String name;

    @Builder
    public AnswerEntity(List<String> dataList, int age, String name) {
        this.dataList = dataList;
        this.age = age;
        this.name = name;
    }

}
