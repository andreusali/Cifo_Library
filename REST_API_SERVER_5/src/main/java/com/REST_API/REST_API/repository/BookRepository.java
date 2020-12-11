package com.REST_API.REST_API.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.User;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{

	Optional<Book> findById(long id);
}
