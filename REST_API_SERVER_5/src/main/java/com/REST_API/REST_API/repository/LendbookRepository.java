package com.REST_API.REST_API.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Lendbook;


@Repository
public interface LendbookRepository extends CrudRepository<Lendbook,Long>{

	/* List<Author> findById(Author author,Long id); */
	
}
