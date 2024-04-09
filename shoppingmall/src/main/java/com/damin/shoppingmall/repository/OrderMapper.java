package com.damin.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.damin.shoppingmall.model.Orders;

@Mapper
public interface OrderMapper {
	
	@Select("select * from orders")
	List<Orders> selectAllOrders();
	
	void insertOrder(Orders orders);
	
}