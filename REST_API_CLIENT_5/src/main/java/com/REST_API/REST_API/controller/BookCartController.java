package com.REST_API.REST_API.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.BookCart;
import com.REST_API.REST_API.service.BookCartService;
import com.REST_API.REST_API.service.BookService;
import com.REST_API.REST_API.utils.StatusSession;

@Controller
@RequestMapping(value="/carts")
public class BookCartController {
	
	@Autowired
	BookService service;
	
	@Autowired
	BookCartService cartservice;
	
	@GetMapping(value="show")
	public String homeCart(Model model, HttpSession session) {
		session.getAttribute("user");
		session.getAttribute("cart");
		//return "carts/cart";
		return "carts/cart";
	}
	
	@GetMapping(value="showAllBooks")
	public String showAllBooks (Model model, HttpSession session) {	
	session.getAttribute("user");
	model.addAttribute("books", service.findAll());
	return "carts/itembooks";
	}
		
	
	@GetMapping(value="addToCart")
	public String add(@RequestParam("itemId") Long id, HttpSession session) {
	
		if(session.getAttribute("cart")==null) {
	
			List<BookCart> cart = new ArrayList<BookCart>();

			cart.add(new BookCart(service.findById(id), 1));
			session.setAttribute("cart", cart);
			session.setAttribute("status", StatusSession.TOLEND);
			
		}else {
			List<BookCart> cart = (List<BookCart>) session.getAttribute("cart");
			int index = this.exists(id, cart);
			if(index==-1) {
				
				cart.add(new BookCart(service.findById(id), 1));
			}else {
				int quantity = cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			
			session.setAttribute("cart", cart);
		
		}
		//return "carts/itembooks";
		return "redirect:/carts/show";
		
	}
	
	@GetMapping(value="removeFromCart")
	public String remove(@RequestParam("itemId")Long id, HttpSession session) {
		
		List<BookCart> cart = (List<BookCart>) session.getAttribute("cart");
		
		int index = this.exists(id, cart);
		int quantity = cart.get(index).getQuantity();
		
		if(quantity>0) {
			
			quantity--;
			cart.get(index).setQuantity(quantity);
			
			if(quantity==0)
				cart.remove(index);
		}
		session.setAttribute("cart", cart);
		
		//return "redirect:/carts/itembooks";
		return "redirect:/carts/show";
	}
	
	
	private int exists(Long id, List<BookCart> cart) {

		for (int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getBook().getId()==id) {
				return i;
			}
		
		}
		return -1;
	}
		
			
}
