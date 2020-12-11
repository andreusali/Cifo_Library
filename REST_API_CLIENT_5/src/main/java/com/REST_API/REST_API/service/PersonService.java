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
import com.REST_API.REST_API.model.Person;

@Service
public class PersonService {

	RestTemplate template = new RestTemplate();
	
	public Iterable<Person> findAll(){
		
		ResponseEntity<List<Person>> response = 
		template.exchange("http://localhost:8080/webapi/persons",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
			});
		List<Person> pers = response.getBody();
		return pers;
	}
	
	public void insertPerson(Person ps) {
		HttpEntity<Person> request = new HttpEntity<>(ps);
		template.postForObject("http://localhost:8080/webapi/persons", request, Person.class);
	}
	
	public void deletePerson(Person ps) {
		
		template.delete("http://localhost:8080/webapi/persons/"+ps.getId());
	}

	
}
