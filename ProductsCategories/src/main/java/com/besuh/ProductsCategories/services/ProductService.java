package com.besuh.ProductsCategories.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besuh.ProductsCategories.models.Product;
import com.besuh.ProductsCategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pr;
	
	public ProductService() {
	}
	
	public ProductService(ProductRepository pr) {
		this.pr = pr;
	}
	public ArrayList<Product> all() {
		return (ArrayList<Product>) pr.findAll();
	}
	public Product findProductById(long id) {
		return (Product) pr.findById(id).orElse(null);
	}
	public void create(Product s) {
		System.out.println(s + " in the service");
		pr.save(s);
	}
	public void update(Product product) {
		pr.save(product);
	}
	public void destroy(long id) {
		pr.deleteById(id);
	}
}
