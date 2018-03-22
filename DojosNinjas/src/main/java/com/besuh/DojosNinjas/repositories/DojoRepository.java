package com.besuh.DojosNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.besuh.DojosNinjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Integer> {
	List<Dojo> findAll();
}
