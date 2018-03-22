package com.project.ProductsAndCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.ProductsAndCategories.models.Product;
import com.project.ProductsAndCategories.services.ProductService;

@Controller
public class ProductController{
	private ProductService productService;

	public ProductController(ProductService productService){
		this.productService=productService;
	}

	@PostMapping("/products/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult res) {
		productService.create(product);
		return "redirect:/";
	}

}