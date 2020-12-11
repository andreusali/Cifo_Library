package com.REST_API.REST_API.service;

import java.util.ArrayList;
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


@Service
public class AuthorService {
	
	RestTemplate template = new RestTemplate();
	
	public Iterable<Author> findAll(){
		
		ResponseEntity<List<Author>> response = 
		template.exchange("http://localhost:8080/webapi/authors",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<Author>>() {
			});
		List<Author> authors = response.getBody();
		return authors;
	}
	
	public void insertAuthor(Author author) {
		HttpEntity<Author> request = new HttpEntity<>(author);
		template.postForObject("http://localhost:8080/webapi/authors", request, Author.class);
	}
	
	public void deleteAuthor(Author author) {
		
		template.delete("http://localhost:8080/webapi/authors/"+author.getId());
	}

	
}

