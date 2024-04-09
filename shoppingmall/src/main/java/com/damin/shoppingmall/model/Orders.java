package com.damin.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Orders {
	
	private Long orderId;
	@NonNull private Long memberId;
	@NonNull private String prodName;
	@NonNull private Integer count;
	

}