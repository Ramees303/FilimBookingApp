package com.Filim.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Filim.Entity.BookingDateAndTime;
import com.Filim.Entity.BookingSeat;
import com.Filim.Entity.Order;
import com.Filim.Service.BookingDateAndTimeService;
import com.Filim.Service.BookingSeatService;
import com.Filim.repository.BookingSeatRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookingSeatController {
	
    @Autowired
    private BookingDateAndTimeService bookingdatetimeservice;
    
    @Autowired
    private BookingSeatService bookingseatservice;
    

    @Autowired
    private BookingSeatRepository repo;
	
 //Taking the date and time  and pass it through model	
    
	@PostMapping("/bookingseat/{moviename}")
	public String getSeatBooking(@PathVariable("moviename")String moviename,@ModelAttribute BookingDateAndTime data,Model model,HttpSession session) {
		
		data.setBookingdate(String.valueOf(java.time.LocalDate.now()));
		data.setMoviename(moviename);
		
		BookingDateAndTime bookingdate1=bookingdatetimeservice.save(data);
		
		
		List<Integer> bookingids=bookingdatetimeservice.getbooking_id(moviename, data.getDate(),data.getTime() );
		
		
		//we get a list of string that contains seat that string contain different string of seat
		//we are converting list to string and split the input by , and add adding to the new list
		List<String> seats=repo.getseatdata(bookingids);
		
		

		String seat=seats.toString();
		String arr[]=null;
		List<String> bookedseats=new ArrayList<>();
		arr=seat.split("[^-\\w]"); //split everything excluding -,[a-zA-Z_0-9]
		for(String i:arr) {
			System.out.println(i);
				bookedseats.add(i);
			
		}
	
	    model.addAttribute("seatlist",bookedseats);
	    
		
	
		model.addAttribute("moviename",bookingdate1.getMoviename() );
		model.addAttribute("date",bookingdate1.getDate());
		model.addAttribute("time",bookingdate1.getTime());
		model.addAttribute("bookingid",bookingdate1.getBooking_id());
		
		
		
		
		return "bookingseat";
		
	}
	
	
	//updating data from bookingform
	@PostMapping("/bookingseat")
	public String updateSeatBooking(@ModelAttribute BookingDateAndTime data ,Model model,HttpSession session) {
		
		data.setBookingdate(String.valueOf(java.time.LocalDate.now()));
		
		System.out.println(data);
		BookingDateAndTime bookingdate2=bookingdatetimeservice.save(data);
		
		
	List<Integer> bookingids=bookingdatetimeservice.getbooking_id(data.getMoviename(),data.getDate(), data.getTime() );
		
		
		//we get a list of string that contains seat that string contain different string of seat
		//we are converting list to string and split the input by , and add adding to the new list
		List<String> seats=repo.getseatdata(bookingids);
		
		

		String seat=seats.toString();
		String arr[]=null;
		List<String> bookedseats=new ArrayList<>();
		arr=seat.split("[^-\\w]"); //split everything excluding -,[a-zA-Z_0-9]
		for(String i:arr) {
			System.out.println(i);
				bookedseats.add(i);
			
		}
	
	    model.addAttribute("seatlist",bookedseats);
	    
		
	
		model.addAttribute("moviename",bookingdate2.getMoviename() );
		model.addAttribute("date",bookingdate2.getDate());
		model.addAttribute("time",bookingdate2.getTime());
		model.addAttribute("bookingid",bookingdate2.getBooking_id());
		
		return "bookingseat";
		
	

	
	}
	
	
	
	//getting data from seatbooking
	
	@PostMapping("/savebookingseat{bookid}")
	public String saveBookingseatdata(@ModelAttribute BookingSeat seatbookdata, @PathVariable("bookid") int bookid,HttpSession session) {
		
		bookingseatservice.saveBookingSeat(bookid, session, seatbookdata);
	
		
		
		return "redirect:/order";
		
	}
	
	

}
