package com.Filim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Filim.Entity.Order;
import com.Filim.Service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
@Autowired
private OrderService orderservice;
	
	@GetMapping("/order")
	public String getorder(HttpSession session,Model model) {
		
		List<Order> orderlist=orderservice.getorder(session);
		model.addAttribute("order", orderlist);
		
		if(session.getAttribute("email")==null) {
			return "login";
		}
		
		return "order";
		
	}
	
	
	

}
