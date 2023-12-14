package com.Filim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Filim.Entity.Movie;
import com.Filim.Service.BookingDateAndTimeService;
import com.Filim.Service.BookingSeatService;

import jakarta.servlet.http.HttpSession;

@Controller

public class BookingDateAndTimeController {

	@Autowired
	private BookingDateAndTimeService bookingdateandtimeservice;
	
	@PostMapping("/booking{id}")
	public String goingToBooking(@PathVariable("id") int id,HttpSession session,Model model) {
	    
		Movie movie=bookingdateandtimeservice.getMovie(id);
		
		model.addAttribute("movie",movie);
		return "bookingdateandtime";
	}
	
	
	
	
}
