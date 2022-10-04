package com.project.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.boot.entity.Product;
import com.project.boot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service; ////////////////////////////////////////save

	@PostMapping(value = "/saveProduct")
	public ResponseEntity saveProduct(@RequestBody Product product) {
		boolean isAdded = service.saveProduct(product);

		if (isAdded)

			// type must be wrapper class
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		else
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping(value = "/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct() {
		// directly call by ctrl+shft+L
		List<Product> allProduct = service.getAllProduct();
		if (allProduct.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);

		}
	}

	@GetMapping(value = "/getByProductId")
	public ResponseEntity<Product> getByProductId(@RequestParam String productId) {
		Product product = service.getByProductId(productId);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
	}
	

}
