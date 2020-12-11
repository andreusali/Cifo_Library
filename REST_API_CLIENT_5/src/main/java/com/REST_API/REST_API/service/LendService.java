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
import com.REST_API.REST_API.model.Lend;

@Service
	public class LendService {
			
	RestTemplate template = new RestTemplate();
	
	public Iterable<Lend> findAll(){
		
		ResponseEntity<List<Lend>> response = 
		template.exchange("http://localhost:8080/webapi/lends",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<Lend>>() {
			});
		List<Lend> ls = response.getBody();
		return ls;
	}
	
	public void insertLend(Lend ld) {
		HttpEntity<Lend> request = new HttpEntity<>(ld);
		template.postForObject("http://localhost:8080/webapi/lends", request, Lend.class);
	}
	
	public void deleteLend(Lend ld) {
		
		template.delete("http://localhost:8080/webapi/lends/"+ld.getId());
	}

	
}
