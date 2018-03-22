package com.project.ProductsAndCategories.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.ProductsAndCategories.models.CategoryProduct;
import com.project.ProductsAndCategories.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	private CategoryProductRepository categoryProductRepository;
	
	public CategoryProductService(CategoryProductRepository categoryProductRepository){
		this.categoryProductRepository=categoryProductRepository;
	}

	public ArrayList<CategoryProduct> all(){
		return (ArrayList<CategoryProduct>)categoryProductRepository.findAll();
	}
}