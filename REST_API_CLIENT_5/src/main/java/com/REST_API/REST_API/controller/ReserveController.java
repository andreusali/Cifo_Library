package com.REST_API.REST_API.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.REST_API.REST_API.model.BookCart;
import com.REST_API.REST_API.utils.StatusSession;


@Controller
@RequestMapping(value = "/reservation")
public class ReserveController {

		@RequestMapping(value ="/show")
		public String show (HttpSession session) {

			if (session.getAttribute("cart") == null) {

				// System.out.println("Cart null");

			} else {

				List<BookCart> cart = (List<BookCart>) session.getAttribute("cart");
				session.setAttribute("cart", cart);
				session.setAttribute("status", StatusSession.TOLEND);
			}

		
			return "carts/reservation";
			//return "shoping/pay";
		}
		
		
		@RequestMapping(value ="/reserved")
		public String reserveBook (HttpSession session, Model model) {
		//public String payWithCard (HttpSession session, Model model) {


				if (session.getAttribute("cart") != null) {
					
					
					model.addAttribute("user", session.getAttribute("user"));
					model.addAttribute("sid", session.getAttribute("sid"));
					
					session.setAttribute("status", StatusSession.FINISHED);
					model.addAttribute("status", session.getAttribute("status"));	
				}

				session.invalidate();
			
			
			return "carts/finished";
			//return "shoping/finished";
		}	
	
}
