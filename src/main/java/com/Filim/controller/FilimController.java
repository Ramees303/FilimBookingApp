package com.Filim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Filim.Entity.ContactUs;
import com.Filim.Entity.Movie;
import com.Filim.Service.MovieService;
import com.Filim.repository.ContactRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class FilimController {

	@Autowired
	private MovieService movieservice;
	
	@Autowired
	private ContactRepository contactrepository;
	
//This class will contain home and logout and contact controller
	

	
	@GetMapping("/")
	public String home(Model model,HttpSession session) {
		List<Movie> presentmovie=movieservice.getMovieData("Available");
		List<Movie> futuremovie=movieservice.getMovieData("Comingsoon");
		System.out.println(presentmovie);
		model.addAttribute("data",presentmovie);
		model.addAttribute("futuremovie",futuremovie );
		
		if(session.getAttribute("email")==null) {
			return "login";
		}
		
		return "home";
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@PostMapping("/submitcontact")
	public String savemessage(@ModelAttribute ContactUs contact)
	{
		contactrepository.save(contact);
		return "login";
	}
	
}
