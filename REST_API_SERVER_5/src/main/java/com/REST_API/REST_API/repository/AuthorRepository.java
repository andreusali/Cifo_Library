package com.REST_API.REST_API.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Author;


@Repository
public interface AuthorRepository extends CrudRepository<Author,Long>{

	/* List<Author> findById(Author author,Long id); */
	
}
