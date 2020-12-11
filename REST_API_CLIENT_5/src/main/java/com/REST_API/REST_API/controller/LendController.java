package com.REST_API.REST_API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.Lend;
import com.REST_API.REST_API.service.AuthorService;
import com.REST_API.REST_API.service.BookService;
import com.REST_API.REST_API.service.LendService;
import com.REST_API.REST_API.service.LendbookService;
import com.REST_API.REST_API.service.UserService;
import com.REST_API.REST_API.service.UserService;

@Controller
@RequestMapping("/lends")
public class LendController {

	@Autowired
	LendService lendservice;

	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/lends")
	public String showLends (Model model) {		
	model.addAttribute("lends", lendservice.findAll());
	model.addAttribute("users", userservice.findAll());
	return "lends/lends";
	}
	
    @RequestMapping(value = "/newLend")
    public String newLend(Model model) {
    	model.addAttribute("users", userservice.findAll());
    	model.addAttribute("lend", new Lend());
        return "lends/newLend";
    }

    @RequestMapping(value = "/insertLend", consumes= {"application/x-www-form-urlencoded", "application/json;charset=utf-8"},
    		produces = "application/json;charset=utf-8")
	public String insertLend(Lend lend, Model model) {
        lendservice.insertLend(lend);
        model.addAttribute("lends", lendservice.findAll());
        return "lends/lends";
    }

    @RequestMapping("/deleteLend")
	public String deleteLend(@RequestParam("id") Long id, Model model) {		
    	Lend lend = new Lend();
	    lend.setId(id);
    	lendservice.deleteLend(lend);
    	model.addAttribute("lends", lendservice.findAll());
    	return "lends/lends.html";
	}


}