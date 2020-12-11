package com.REST_API.REST_API.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.Lend;

@Repository
public interface LendRepository extends CrudRepository<Lend,Long>{

}
