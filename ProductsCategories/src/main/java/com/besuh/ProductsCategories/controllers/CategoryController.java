package com.besuh.ProductsCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.besuh.ProductsCategories.models.Category;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	public CategoryController() {
		
	}
	@RequestMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newCategory";
	}
	@PostMapping("/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category) {
		return "redirect:/"+category.getId();
	}
	@RequestMapping("/{id}")
	public String showCategory(@PathVariable("id") long id, Model model) {
		model.addAttribute("wat", "st");
		return "category";
	}
}
