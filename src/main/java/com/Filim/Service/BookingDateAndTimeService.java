package com.Filim.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Filim.Entity.BookingDateAndTime;
import com.Filim.Entity.Movie;
import com.Filim.repository.BookingDateAndTimeRepository;
import com.Filim.repository.MovieRepository;

@Service
public class BookingDateAndTimeService {
	
	@Autowired
	private BookingDateAndTimeRepository  bookingdatetimerepository;
	
	
	@Autowired
	private MovieRepository movierepository;
	
	
	public BookingDateAndTime save(BookingDateAndTime bookdata) {
	      return bookingdatetimerepository.save(bookdata);
		
	}

	
	
	
	public Movie getMovie(int id) {
		return movierepository.findById(id).orElse(null);
		
	}
	
	public List<Integer> getbooking_id(String moviename,String date,String time){
		return bookingdatetimerepository.getBookingid(moviename, date, time);
	}
	

}
