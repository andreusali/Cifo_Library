package com.REST_API.REST_API.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person,Long>{

	/* List<Author> findById(Author author,Long id); */
	
}
