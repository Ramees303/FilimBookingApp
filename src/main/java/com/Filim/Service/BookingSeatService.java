package com.Filim.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Filim.Entity.BookingDateAndTime;
import com.Filim.Entity.BookingSeat;
import com.Filim.Entity.Order;
import com.Filim.Entity.User;
import com.Filim.repository.BookingDateAndTimeRepository;
import com.Filim.repository.BookingSeatRepository;
import com.Filim.repository.OrderRepository;
import com.Filim.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class BookingSeatService {

	@Autowired
	private Order order;
	
	@Autowired
	private BookingSeatRepository bookingseatrepository;
	
	@Autowired
	private BookingDateAndTimeRepository bookingdateandtimerepository;

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private OrderRepository  orderrepository;
	
	
	public void saveBookingSeat(int bookid,HttpSession session,BookingSeat bookingseatdata) {
	
		
	
	 
	 //Bookingdateandtime
	 BookingDateAndTime bookingdateandtime=bookingdateandtimerepository.findById(bookid).orElse(null);
	 bookingseatdata.setBooking_id(bookingdateandtime);
	 List<BookingSeat> bookinglist1=new ArrayList<>();
	 bookinglist1.add(bookingseatdata);
	 bookingdateandtime.setBooked_seat_id(bookinglist1);
	 
	 //User
	User user=userRepository.findByEmail(String.valueOf(session.getAttribute("email")));
	 List<BookingSeat> bookinglist=new ArrayList<>();
	 bookinglist.add(bookingseatdata);
	 user.setUserseatbooking(bookinglist);
	 bookingseatdata.setUser_id(user);
		
	 System.out.println(bookingseatdata);
	 bookingseatrepository.save(bookingseatdata);
	 
	 
	 /***********creating order*********/
	 
	 
	 order.setSeats(bookingseatdata.getSeatbooked());
	 order.setTotalprice(bookingseatdata.getTotalprice());
	 order.setBookingdate(bookingdateandtime.getBookingdate());
	 order.setShowdate(bookingdateandtime.getDate());
	 order.setShowtime(bookingdateandtime.getTime());
	 order.setMoviename(bookingdateandtime.getMoviename());
	 
	 order.setUser(user);
	 
	 List<Order> orderlist=new ArrayList<>();
	 orderlist.add(order);
	 
	 user.setOrder_id(orderlist);
	 
	 userRepository.save(user);
	 orderrepository.save(order);
	 
	 /*****************order creation ended******************************/
	 
		
//	 userRepository.save(user);
//     bookingdateandtimerepository.save(bookingdateandtime);
		
	 
		
		
		
	}
	
	
	
}
