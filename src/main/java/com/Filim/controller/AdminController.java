package com.Filim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Filim.Entity.ContactUs;
import com.Filim.Entity.Order;
import com.Filim.Entity.User;
import com.Filim.repository.ContactRepository;
import com.Filim.repository.OrderRepository;
import com.Filim.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private OrderRepository orderrepository;
	
	@Autowired
	private ContactRepository contactrepository;
	
	@GetMapping("adminhome")
	public String adminhome(HttpSession session) {
		
		if(session.getAttribute("email")==null) {
			
			return "login";
		}
		
		if(session.getAttribute("email").equals("admin@gmail.com")) {
			return "adminhome";
		}
		
		return "login";
	   }
	
	
	 @GetMapping("adminbooking")
	 public String adminBooking(HttpSession session,Model model) {
        if(session.getAttribute("email")==null) {
			
			return "login";
		}

		if(session.getAttribute("email").equals("admin@gmail.com")) {
			
			
			
			
			
				
				
				List<User> userlist=userrepository.findAll();
				
				List<Order> orderlist=orderrepository.findAll();
				
				model.addAttribute("order", orderlist);
			
			
			return "adminbooking";
		}
		
		return "login";
	   }
	
	
	@GetMapping("adminmessage")
	public String adminMessage(HttpSession session,Model model) {
    if(session.getAttribute("email")==null) {
			
			return "login";
		}

		if(session.getAttribute("email").equals("admin@gmail.com")) {
			
			
			List<ContactUs> msglist=contactrepository.findAll();
			model.addAttribute("msglist",msglist);
			
			
			return "adminmessage";
		}
		
		return "login";
	   }
	
	
	@GetMapping("adminaddmovies")
	public String adminaddMovies(HttpSession session) {
		
      if(session.getAttribute("email")==null) {
			
			return "login";
		}

		if(session.getAttribute("email").equals("admin@gmail.com")) {
			return "adminaddmovies";
		}
		
		return "login";
	   }
	
	
	@GetMapping("adminlogout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "login";
	   }
	
	
	
}
