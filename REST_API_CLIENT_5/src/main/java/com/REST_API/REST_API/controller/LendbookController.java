package com.REST_API.REST_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.Lend;
import com.REST_API.REST_API.model.Lendbook;
import com.REST_API.REST_API.service.AuthorService;
import com.REST_API.REST_API.service.BookService;
import com.REST_API.REST_API.service.LendService;
import com.REST_API.REST_API.service.LendbookService;
import com.REST_API.REST_API.service.UserService;

@Controller
@RequestMapping("/lendbooks")
public class LendbookController {

	@Autowired
	LendbookService lendbookservice;

	@Autowired
	LendService lendservice;

	@Autowired
	BookService bookservice;
	
	@GetMapping(value="/lendbooks")
	public String showLendbooks (Model model) {		
	model.addAttribute("lendbooks", lendbookservice.findAll());
	model.addAttribute("books", bookservice.findAll());
	model.addAttribute("lends", lendservice.findAll());
	return "lendbooks/lendbooks";
	}
	
    @GetMapping(value = "/newLendbook")
    public String newLendbook(Model model) {
    	model.addAttribute("lendbook", new Lendbook());
    	model.addAttribute("lends", lendservice.findAll());
    	model.addAttribute("books", bookservice.findAll());
        return "lendbooks/newLendbook";
    }

    @PostMapping(value = "/insertLendbook", consumes= {"application/x-www-form-urlencoded", "application/json;charset=utf-8"},
    		produces = "application/json;charset=utf-8")
	public String insertLendbook(Lendbook lendbook, Model model) {
        lendbookservice.insertLendbook(lendbook);
    	model.addAttribute("lends", lendservice.findAll());
    	model.addAttribute("books", bookservice.findAll());
        model.addAttribute("lendbooks", lendbookservice.findAll());
        return "lendbooks/lendbooks";
    }
 
    @DeleteMapping("/deleteLendbook")
	public String deleteLendbook(@RequestParam("id") Long id, Model model) {		
    	Lendbook lendbook = new Lendbook();
	    lendbook.setId(id);
    	lendbookservice.deleteLendbook(lendbook);
    	model.addAttribute("lendbooks", lendbookservice.findAll());
    	return "lendbooks/lendbooks";
	}


}