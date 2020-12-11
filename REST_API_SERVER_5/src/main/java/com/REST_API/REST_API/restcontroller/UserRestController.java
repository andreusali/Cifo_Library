package com.REST_API.REST_API.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.User;
import com.REST_API.REST_API.repository.UserRepository;

@RestController
@RequestMapping("/webapi")
//@RequestMapping(value = "/")
//, produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserRestController {
  
  @Autowired
  UserRepository userrepository;
   
   @GetMapping("/users")
   public Iterable<User> getUsers() {

    return userrepository.findAll();
   }
   
	@GetMapping(value="/users/{id}")
	public Optional<User> getUser(@PathVariable(value = "id")Long id) {	
	Optional<User> user = userrepository.findById(id);
	
		return user;
	
	}
    
   @PostMapping(path="/users", consumes={"application/x-www-form-urlencoded", "application/json;charset=utf-8"}, 
		   produces = "application/json;charset=utf-8") 
   public void saveUser(@RequestBody User user){
      userrepository.save(user);
   }
    
   @DeleteMapping("/users/{userId}")
   public void deleteUser(@PathVariable(name="userId")Long userId){
	   Optional<User> user = userrepository.findById(userId);
	   if(user.isPresent()) {
		   
		   userrepository.delete(user.get());
	   }
   }
    
//   @PutMapping("/studs/{studentId}")
//   public void updateStudent(@RequestBody Student student,
//     @PathVariable(name="studentId")Long studentId){
//	   student.setStudentid(studentId);
//	   student.setName(student.getName());
//        service.saveStudentByStudent(student);
//    
//   }
    

    
  
  
}
