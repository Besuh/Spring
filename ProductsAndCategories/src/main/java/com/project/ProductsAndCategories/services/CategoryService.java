package com.project.ProductsAndCategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ProductsAndCategories.repositories.CategoryRepository;
import com.project.ProductsAndCategories.models.Category;

@Service
public class CategoryService{
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository=categoryRepository;
	}
	
	public ArrayList<Category> all(){
		return (ArrayList<Category>) categoryRepository.findAll();
	}
	public Category findById(long id){
		return (Category) categoryRepository.findOne(id);
	} 
	public void create(Category category){
		categoryRepository.save(category);
	}
	public void update(Category category) {
		categoryRepository.save(category);
	}
	public void destroy(long id){
		categoryRepository.delete(id);
	}
}