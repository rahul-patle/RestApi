package com.project.boot.service;

import java.util.List;

import com.project.boot.entity.Product;

public interface ProductService {

	
	public boolean saveProduct( Product product);
	
	public List<Product> getAllProduct();

	public Product getByProductId(String productId);

	public boolean updateProduct(Product product);

	public boolean deleteProductById(int productId);

}
