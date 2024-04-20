package com.damin.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	private Long memberId;
	@NonNull private String name;
	@NonNull private String userId;
	@NonNull private String pw;
	@NonNull private String address;
	@NonNull private int zipcode;
	@NonNull private int year;
	@NonNull private int month;
	@NonNull private int day;

}