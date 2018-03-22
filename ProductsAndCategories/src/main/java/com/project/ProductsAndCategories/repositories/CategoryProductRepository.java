package com.project.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.ProductAndCategories.models.CategoryProduct;

@Repository 												
public interface CategoryProductRepository extends CrudRepository<CategoryProduct,Long>{

}