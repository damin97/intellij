package com.damin.shoppingmall.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.damin.shoppingmall.model.Product;

@Mapper
public interface ProductMapper {
	@Select("select count(*) from products")
	int count();
	
	Product selectProductById(Long id);
	List<Product> selectAllProducts();
	void insertProduct(Product product);
	void updateProduct(Product product);

	int deleteProduct(Long prodId);
}
