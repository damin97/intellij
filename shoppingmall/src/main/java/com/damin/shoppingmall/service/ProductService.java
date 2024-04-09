package com.damin.shoppingmall.service;

import com.damin.shoppingmall.model.Product;
import com.damin.shoppingmall.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
	
	@Value("${upload.dir}")
    private String uploadDir;


    @Autowired
    private ProductMapper productMapper;

    public Product getProductById(Long prodId) {

        return productMapper.selectProductById(prodId);
    }

    public List<Product> getAllProducts() {

        return productMapper.selectAllProducts();
    }

	public void addProduct(Product product) throws IOException {
        
		productMapper.insertProduct(product);
	}
	
	public void updateProduct(Product product) {
		productMapper.updateProduct(product);
	}

	public int deleteProduct(Long prodId) {

		return productMapper.deleteProduct(prodId);
	}
}
