package com.Filim.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Filim.Entity.Order;
import com.Filim.Entity.User;
import com.Filim.repository.OrderRepository;
import com.Filim.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository orderrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	
	public List<Order> getorder(HttpSession session){
		
		User user=userrepository.findByEmail(String.valueOf(session.getAttribute("email")));
		List<Order> orderlist=orderrepository.findByUser(user);
		return orderlist;
	}
	
	
}
