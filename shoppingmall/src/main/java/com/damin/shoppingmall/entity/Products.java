package com.damin.shoppingmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.NonNull;

@Entity
public class Products {
	@Id // primary key를 의미한다
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment를 의미한다
	private Long prodId;
	private String prodName;
	private Integer prodPrice;
	private String prodDetail;
	private String prodImg;
}
