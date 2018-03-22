package com.besuh.ProductsCategories.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.besuh.ProductsCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}