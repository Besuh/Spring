package com.besuh.ProductsCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.besuh.ProductsCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

}
