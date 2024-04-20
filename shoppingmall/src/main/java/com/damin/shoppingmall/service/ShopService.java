package com.damin.shoppingmall.service;

import com.damin.shoppingmall.model.Shop;
import com.damin.shoppingmall.repository.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public List<Shop> getAllShopByMemberId(Long memberId) {
        return shopMapper.selectAllShopByMemberId(memberId);
    }
}
