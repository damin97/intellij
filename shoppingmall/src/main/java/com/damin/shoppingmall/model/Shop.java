package com.damin.shoppingmall.model;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Shop {

    private Long shopId;
    @NonNull private Long memberId;
    @NonNull private Long prodId;
    @NonNull private Integer count;
}
