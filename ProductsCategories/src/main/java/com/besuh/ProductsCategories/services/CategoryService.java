package com.besuh.ProductsCategories.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besuh.ProductsCategories.models.Category;
import com.besuh.ProductsCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cr;
	public CategoryService() {
		
	}
	public CategoryService(CategoryRepository cr) {
		this.cr =cr;
	}
	public ArrayList<Category> all(){
		return (ArrayList<Category>) cr.findAll();
	}
	public Category findCategoryById(long id) {
		return cr.findById(id).orElse(null);
	}
	public void create(Category category) {
		cr.save(category);
	}
	public void update(Category category) {
		cr.save(category);
	}
	public void destroy(long id) {
		cr.deleteById(id);
	}
}
