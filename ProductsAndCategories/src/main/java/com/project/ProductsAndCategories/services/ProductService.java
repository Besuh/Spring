package com.project.ProductsAndCategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.project.ProductsAndCategories.repositories.ProductRepository;
import com.project.ProductsAndCategories.models.Product;

@Service
public class ProductService {
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository){
		this.productRepository=productRepository;
	}

	public ArrayList<Product> all() {
		return (ArrayList<Product>) productRepository.findAll();
	}

	public Product findById(long id) {
		return (Product) productRepository.findOne(id);
	}

	public void create(Product product) {
		productRepository.save(product);
	}

	public void update(Product product) {
		productRepository.save(product);
	}

	public void destroy(long id) {
		productRepository.delete(id);
	}

}