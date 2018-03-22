package com.besuh.DojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.besuh.DojosNinjas.models.Product;

@Repository
public interface NinjaRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findDistinctProductsByCategoryID(Integer id);
}
