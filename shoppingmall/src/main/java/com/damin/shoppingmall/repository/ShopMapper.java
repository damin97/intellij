package com.damin.shoppingmall.repository;

import com.damin.shoppingmall.model.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopMapper {

    List<Shop> selectAllShopByMemberId(Long memberId);

    void insertShop(Shop shop);

    void deleteShop(Long prodId);
}
