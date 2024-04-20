package com.damin.shoppingmall.service;

import com.damin.shoppingmall.model.Heart;
import com.damin.shoppingmall.model.Member;
import com.damin.shoppingmall.repository.HeartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HeartService {

    @Autowired
    HeartMapper heartMapper;

    public Heart getHeartByProdId(Long prodId) {

        return heartMapper.selectHeartByProdId(prodId);
    }

    public List<Heart> getAllHeartByMemberId(Long memberId) {
        return heartMapper.selectAllHeartByMemberId(memberId);
    }

    public void addLike(Heart heart) throws IOException {

        heartMapper.insertHeart(heart);
    }

    public void deleteLike(Long prodId) {

        heartMapper.deleteHeart(prodId);
    }
}
