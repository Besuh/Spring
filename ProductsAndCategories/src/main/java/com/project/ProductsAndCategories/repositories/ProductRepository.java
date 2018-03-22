package com.project.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.ProductsAndCategories.models.Product;

@Repository 												
public interface ProductRepository extends CrudRepository<Product,Long>{
	
}