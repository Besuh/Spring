package com.project.ProductsAndCategories.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.ProductsAndCategories.services.CategoryProductService;
import com.project.ProductsAndCategories.services.CategoryService;
import com.project.ProductsAndCategories.services.ProductService;
import com.project.ProductsAndCategories.models.Category;
import com.project.ProductsAndCategories.models.Product;

@Controller
public class CategoryController{
	private CategoryService categoryService;
	private ProductService productService;
	private CategoryProductService categoryProductService;

	public CategoryController(CategoryService categoryService, ProductService productService, 
			CategoryProductService categoryProductService){
		this.categoryService=categoryService;
		this.productService=productService;
		this.categoryProductService=categoryProductService;
	}
	
	@RequestMapping("")
	public String index(@ModelAttribute("product") Product product, @ModelAttribute("category") Category category,Model model){
		model.addAttribute("categories",categoryService.all());
		model.addAttribute("products",productService.all());
		model.addAttribute("categories_products",categoryProductService.all());
		return "index";
	}

	@PostMapping("/categories/new")
	public String create(@Valid @ModelAttribute("category") Category category){
		categoryService.create(category);
		return "redirect:/";
	}

	@PostMapping("/add")
	public String add( @RequestParam("category") long category_id, @RequestParam("product") long product_id ){
		Category cat = categoryService.findById(category_id);
		Product pro  = productService.findById(product_id);

		List<Product> products = cat.getProducts();
		products.add(pro);

		categoryService.update(cat);

		return "redirect:/";
	}
}