package com.REST_API.REST_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.User;
import com.REST_API.REST_API.service.AuthorService;
import com.REST_API.REST_API.service.BookService;
import com.REST_API.REST_API.service.UserService;
import com.REST_API.REST_API.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService sservice;
	
	@GetMapping(value="/showUsers")
	public String showUsers (Model model) {		
		model.addAttribute("users", sservice.findAll());
	return "users/users";
	}
	
    @GetMapping(value = "/newUser")
    public String newUser(Model model) {
    	model.addAttribute("user", new User());
    	model.addAttribute("users", sservice.findAll());
        return "users/newUser";
    }

    @PostMapping(value = "/insertUser", consumes= {"application/x-www-form-urlencoded", "application/json;charset=utf-8"},
    		produces = "application/json;charset=utf-8")
	public String insertUser(@ModelAttribute("user")User user, Model model) {
        sservice.insertUser(user);
        model.addAttribute("users", sservice.findAll());
        return "users/users";
    }

    @RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("id")Long id, Model model) {		
    	User user = new User();
	    user.setId(id);
    	sservice.deleteUser(user);
    	model.addAttribute("users", sservice.findAll());
    	return "users/users";
	}


}