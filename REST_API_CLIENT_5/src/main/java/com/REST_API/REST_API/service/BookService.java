package com.REST_API.REST_API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.User;

@Service
	public class BookService {
			
	RestTemplate template = new RestTemplate();
	
	public Book findById(Long id) {
		Book book = template.getForObject("http://localhost:8080/webapi/books/"+id, Book.class);
		return book;
	}
	
	public Iterable<Book> findAll(){
		ResponseEntity<List<Book>> response = 
		template.exchange("http://localhost:8080/webapi/books",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
			});
		List<Book> books = response.getBody();
		return books;
	}
	
	public void insertBook(Book book) {
		HttpEntity<Book> request = new HttpEntity<>(book);
		template.postForObject("http://localhost:8080/webapi/books", request, Book.class);
	}
	
	public void deleteBook(Book book) {
		
		template.delete("http://localhost:8080/webapi/books/"+book.getId());
	}

	
}