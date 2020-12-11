package com.REST_API.REST_API.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.BookCart;
import com.REST_API.REST_API.model.User;

@Repository
public interface BookCartRepository extends CrudRepository<BookCart,Long>{

	Optional<BookCart> findById(long id);
}
