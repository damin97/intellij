package com.damin._sb0423.pizza.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer total;
    private Integer pickle;
    private Integer chilly;
    private Integer deeping;
    private Integer stick;
    private Integer salad;

    private Boolean complete = false; //완료 버튼 누르면 true로 변하는 필드
}
