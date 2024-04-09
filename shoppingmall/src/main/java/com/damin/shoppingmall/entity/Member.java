package com.damin.shoppingmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //테이블을 만들어준다
public class Member {
	@Id // primary key를 의미한다
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment를 의미한다
	private Long memberId;
	private String name;
	private String userId;
	private String pw;
	private String address;
	private int zipcode;
	private int year;
	private int month;
	private int day;
}
