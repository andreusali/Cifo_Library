package com.REST_API.REST_API.controller;

import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.User;
import com.REST_API.REST_API.service.UserService;
import com.REST_API.REST_API.utils.StatusSession;


@Controller
public class HomeController {
	
	@Autowired
	UserService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
			logger.info("Welcome home! The client locale is {}.", locale);

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

			String formattedDate = dateFormat.format(date);

			model.addAttribute("serverTime", formattedDate);
			model.addAttribute("msg", "Welcome to our library, enjoy your stay, and lend some books...");
			
			
			String sid = session.getId();
			session.setAttribute("sid", sid);
			
			session.setAttribute("status", StatusSession.CREATED);
			session.setAttribute("timestamp", formattedDate);

			//model.addAttribute("clients", service.findAll());
			model.addAttribute("users", service.findAll());	
			
			//return "home/layout";
			return "home/login";
		
	}
	
	@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
	public String loginUser ( @RequestParam("id") Long id, @RequestParam("password")String password, Model model, HttpSession session) {
//	public String loginUser ( @RequestParam("idUser") Long id, Model model, HttpSession session) {
		
		User foundCustomer = service.findById(id);
		
		// Search for a book with an invalid ID
		session.setAttribute("user", foundCustomer);
		//if (foundCustomer.isPresent()) session.setAttribute("user", foundCustomer.get());
		
		if(foundCustomer.getPassword().equals(password)) {
			return "home/home";
		}
		else {

		//return "shoping/home";
		return "home/login";
		}
		
	}
	
//	@RequestMapping(value = { "/*" }, method = RequestMethod.GET)
//	public String error (Locale locale, Model model, HttpSession session) {
//		
//		
//		//to-do error site
//		//return "shoping/error";
//		return "home/error";
//	}


}
