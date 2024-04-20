package com.damin.shoppingmall.entity;

import javax.persistence.*;

@Entity
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    private boolean likeClick;

    private Long memberId;

    private Long prodId;

}
