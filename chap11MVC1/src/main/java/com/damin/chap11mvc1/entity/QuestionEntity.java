package com.damin.chap11mvc1.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "question")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ElementCollection
    @OrderColumn(name = "seq")
    @CollectionTable(name = "question_data", joinColumns = @JoinColumn(name = "id"))
    private List<String> options;
    public boolean isChoice() {
        return options != null && !options.isEmpty();
    }

    @Builder
    public QuestionEntity(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public QuestionEntity(String title) {
        this.title = title;
    }
}
