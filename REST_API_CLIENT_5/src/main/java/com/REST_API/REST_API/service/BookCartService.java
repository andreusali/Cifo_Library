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
import com.REST_API.REST_API.model.BookCart;
import com.REST_API.REST_API.model.User;

@Service
	public class BookCartService {
			
	RestTemplate template = new RestTemplate();
	
	public BookCart findById(Long id) {
		BookCart bookcart = template.getForObject("http://localhost:8080/webapi/bookcarts/"+id, BookCart.class);
		return bookcart;
	}
	
	public Iterable<BookCart> findAll(){
		ResponseEntity<List<BookCart>> response = 
		template.exchange("http://localhost:8080/webapi/bookcarts",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<BookCart>>() {
			});
		List<BookCart> bookcarts = response.getBody();
		return bookcarts;
	}
	
	public void insertBookCart(BookCart bookcart) {
		HttpEntity<BookCart> request = new HttpEntity<>(bookcart);
		template.postForObject("http://localhost:8080/webapi/bookcarts", request, BookCart.class);
	}
	
	public void deleteBookCart(BookCart bookcart) {
		
		template.delete("http://localhost:8080/webapi/bookcarts/"+bookcart.getId());
	}

	
}