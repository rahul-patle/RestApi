package com.project.boot.dao;

import java.util.List;

import com.project.boot.entity.Product;

public interface ProductDao {
	// input is given by client
	public boolean saveProduct( Product product);

	public List<Product> getAllProduct();

	public Product getByProductId(String productId);

	public boolean updateProduct(Product product);

	public boolean deleteProductById(int productId);

}
