package com.REST_API.REST_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.service.AuthorService;
import com.REST_API.REST_API.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookservice;

	@Autowired
	AuthorService authorservice;
	
	@GetMapping(value="/library")
	public String showBooks (Model model) {		
	model.addAttribute("books", bookservice.findAll());
	model.addAttribute("authors", authorservice.findAll());
	//return "books/library";
	return "books/library";
	}
	
    @GetMapping(value = "/newBook")
    public String newBook(Model model) {
    	model.addAttribute("book", new Book());
    	model.addAttribute("books", bookservice.findAll());
    	model.addAttribute("authors", authorservice.findAll());
        //return "books/newBook";
        return "books/newBook";
    } 

    @PostMapping(value = "/insertBook", consumes= {"application/x-www-form-urlencoded", "application/json;charset=utf-8"},
    		produces = "application/json")//;charset=utf-8")
	public String insertBook(@ModelAttribute("book")Book book, Model model) {
        bookservice.insertBook(book);
        model.addAttribute("books", bookservice.findAll());
        //return "books/library";
        return "books/library";
    }

    @RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") Long id, Model model) {		
    	Book book = new Book();
	    book.setId(id);
    	bookservice.deleteBook(book);
    	model.addAttribute("books", bookservice.findAll());
    	return "books/library";
    	//return "books/library";
	}


}