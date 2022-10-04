package com.project.boot.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.boot.dao.ProductDao;
import com.project.boot.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {
		// set id in timestamp of 17 digit
		String Id = new SimpleDateFormat("yyyyMMddHHmmsss").format(new java.util.Date());
		product.setProductId(Id);

		boolean isAdded = dao.saveProduct(product);

		return isAdded;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = dao.getAllProduct();
		return list;
	}

	@Override
	public Product getByProductId(String productId) {
		Product product = dao.getByProductId(productId);
		return product;
	}

	@Override
	public boolean updateProduct(Product product) {

		return false;
	}

	@Override
	public boolean deleteProductById(int productId) {

		return false;
	}

}
