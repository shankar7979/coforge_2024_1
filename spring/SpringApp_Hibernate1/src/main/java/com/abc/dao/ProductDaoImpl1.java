package com.abc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.abc.model.Product;

import lombok.Data;


public class ProductDaoImpl1 implements ProductDao {

	SessionFactory factory;
	Session session,session2;

	public ProductDaoImpl1(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Transactional
	@Override
	public Product addProduct(Product p) {
		session = factory.getCurrentSession();
		if (searchProduct(p.getIsbn()) == null) {
			session.save(p);
			return p;
		}
		return null;
	}

	@Override
	public Product searchProduct(long isbn) {
		session2 = factory.openSession();
		Product product = session2.find(Product.class, isbn);

		if (product != null)
			return product;

		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		session2 = factory.openSession();
		return session2.createQuery("from Product").getResultList();
	}

}
