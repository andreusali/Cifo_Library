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
import com.REST_API.REST_API.model.User;



@Service
public class UserService {
	
	RestTemplate template = new RestTemplate();
	
	public User findById(Long id) {

//		ResponseEntity<User> response = 
//				template.exchange("http://localhost:8080/webapi/users/"+id,
//				HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
//					});
//				User user = response.getBody();
//				
//				return user;
		//HttpEntity<User> request = new HttpEntity<>(id);
		User user = template.getForObject("http://localhost:8080/webapi/users/"+id, User.class);
		return user;
	}
	
	public Iterable<User> findAll(){
		
		ResponseEntity<List<User>> response = 
		template.exchange("http://localhost:8080/webapi/users",
		HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
			});
		List<User> users = response.getBody();
		return users;
	}
	
	public void insertUser(User user) {
		HttpEntity<User> request = new HttpEntity<>(user);
		template.postForObject("http://localhost:8080/webapi/users", request, User.class);
	}
	
	public void deleteUser(User user) {
		
		template.delete("http://localhost:8080/webapi/users/"+user.getId());
	}

	
}


