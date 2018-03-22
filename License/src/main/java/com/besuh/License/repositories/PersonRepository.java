package com.besuh.License.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.besuh.License.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

}
