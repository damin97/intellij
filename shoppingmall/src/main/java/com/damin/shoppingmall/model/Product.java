package com.damin.shoppingmall.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;

@NoArgsConstructor
@RequiredArgsConstructor //요구된거는 final을 의미
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Product {
	
	private Long prodId;
	@NonNull private String prodName;
	@NonNull private int prodPrice;
	@NonNull private String prodDetail;
	@NonNull private String prodImg;
}
