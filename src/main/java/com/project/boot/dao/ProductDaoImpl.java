package com.project.boot.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.boot.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean saveProduct(Product product) {
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();

		boolean isAdded = false;
		try {
			session.save(product);
			transaction.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}
		return isAdded;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);

		List<Product> list = null;
		try {
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}
		return list;

	}

	@Override
	public Product getByProductId(String productId) {
		Session session = sessionfactory.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
		}
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
