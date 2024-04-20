package com.damin.shoppingmall.model;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Heart {
	
	private Long likeId;
	@NonNull private boolean likeClick;
	@NonNull private Long memberId;
	@NonNull private Long prodId;

}