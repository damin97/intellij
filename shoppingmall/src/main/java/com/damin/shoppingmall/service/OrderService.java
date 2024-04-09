package com.damin.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damin.shoppingmall.model.Orders;
import com.damin.shoppingmall.repository.OrderMapper;

@Service
public class OrderService {

	@Autowired
	OrderMapper orderMapper;
	
	public List<Orders> getAllOrders() {
        return orderMapper.selectAllOrders();
    }
	
	@Transactional
    public void newOrder(Orders orders) {

        orderMapper.insertOrder(orders);
    }

}