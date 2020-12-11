package com.REST_API.REST_API.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	/* List<Author> findById(Author author,Long id); */
	
	Optional<User> findById(long id);
	
}
