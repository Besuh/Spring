package com.besuh.ProductsCategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.besuh.ProductsCategories.models.Product;
import com.besuh.ProductsCategories.services.CategoryService;
import com.besuh.ProductsCategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	public ProductService ps;
	public CategoryService cs;
	public ProductController(ProductService ps, CategoryService cs) {
		this.ps = ps;
		this.cs = cs;
	}
	@RequestMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		model.addAttribute("products", ps.all());
		return "newProduct";
	}
	@PostMapping(path="/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		}else {
			System.out.println(product);
			ps.create(product);
			return "redirect:/products/"+product.getId();
		}
	}
	@RequestMapping("/{id}")
	public String showProduct(@PathVariable("id") long id, Model model) {
		Product s = ps.findProductById(id);
		model.addAttribute("category",cs.findCategoryById(id));
		if (s!= null) {
			System.out.println(s + "wow");
			model.addAttribute("x", s);
			return "product";
		}
		else {
			return "redirect:/products/new";
		}
	}
}
