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
import com.REST_API.REST_API.model.Lendbook;



@Service
public class LendbookService {
		
	RestTemplate template = new RestTemplate();
	
	public Iterable<Lendbook> findAll(){
		
		ResponseEntity<List<Lendbook>> response = 
		template.exchange("http://localhost:8080/webapi/lendbooks",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<Lendbook>>() {
			});
		List<Lendbook> lbs = response.getBody();
		return lbs;
	}
	
	public void insertLendbook(Lendbook lb) {
		HttpEntity<Lendbook> request = new HttpEntity<>(lb);
		template.postForObject("http://localhost:8080/webapi/lendbooks", request, Lendbook.class);
	}
	
	public void deleteLendbook(Lendbook lb) {
		
		template.delete("http://localhost:8080/webapi/lendbooks/"+lb.getId());
	}

	
}
