package com.Filim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Filim.Entity.User;
import com.Filim.Service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class UserController {

	
	//This class will contain all user  related Controller
	
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}
	

	@GetMapping("/register")
	public String registerUser() {
		return "register";
	}
	
	
	@GetMapping("/passwordreset")
	public String passwordReset() {
		return "passwordreset";
	}


	@PostMapping("/saveuser")
	public String saveuserData(@ModelAttribute User userdata)  {
	     userservice.saveUser(userdata);
		return "login";
	}
	
	
	
	
	
	
	@PostMapping("/checklogin")
	public String checkUserLogin(@RequestParam("email")String email,@RequestParam("password")String password,Model model,HttpSession session) {
		
		if(email.equals("admin@gmail.com")) {
			if(password.equals("admin")) {
				session.setAttribute("email","admin@gmail.com");
				return "adminhome";
			}
		}
		
		
		int i=0;
		i=userservice.checkUserLogin(email, password);
		if(i==1) {
			User data=userservice.getUserdata(email);
			session.setAttribute("email", data.getEmail());
			return "redirect:/";
		}
		String msg="wrong data";
		model.addAttribute("msg",msg);
		return "login";
		
	}
	
	@PostMapping("/userpasswordreset")
	public String resetUserPassword(@ModelAttribute User userdata,Model model) {
		
	  int i=0;
		i=userservice.resetUserPassword(userdata);
		if(i==1) {
			return "redirect:login";
		}
		String msg="wrong data";
		model.addAttribute("msg",msg);
		return "passwordreset";
	}
	
}
