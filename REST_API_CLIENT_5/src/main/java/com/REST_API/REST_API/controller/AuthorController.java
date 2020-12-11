package com.REST_API.REST_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.service.AuthorService;
import com.REST_API.REST_API.service.BookService;


@Controller
@RequestMapping("/authors")
public class AuthorController {
 
	@Autowired
	AuthorService authorservice;
	
	@GetMapping(value="/authors")
	public String showAuthors (Model model) {		
	model.addAttribute("authors", authorservice.findAll());
	return "authors/authors";
	}
	
	@GetMapping(value = "/newAuthor")
    public String newAuthor(Model model) {
    	model.addAttribute("author", new Author());
        return "authors/newAuthor";
    }

    @PostMapping(value = "/insertAuthor", consumes= {"application/x-www-form-urlencoded", "application/json;charset=utf-8"},
    		produces = "application/json")//;charset=utf-8")
	public String insertAuthor(Author author, Model model) {
        authorservice.insertAuthor(author);
        model.addAttribute("authors", authorservice.findAll());
        return "authors/authors";
    }

    @RequestMapping("/deleteAuthor")
	public String deleteAuthor(@RequestParam("id") Long id, Model model) {		
    	Author author = new Author();
	    author.setId(id);
    	authorservice.deleteAuthor(author);
    	model.addAttribute("authors", authorservice.findAll());
    	return "authors/authors";
	}
	

}