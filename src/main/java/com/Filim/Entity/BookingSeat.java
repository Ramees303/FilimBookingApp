package com.Filim.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="booking_seat")
public class BookingSeat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	
	private int seat_id;
	private int totalprice;
	
	@Column(length = 3000)
	private String seatbooked;
	

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id",nullable = true)
	private  User user_id;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id",nullable = true)
	private BookingDateAndTime book_id;
	
	
	public BookingSeat() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}

    
	
	
	
	
	public BookingDateAndTime getBooking_id() {
		return book_id;
	}






	public void setBooking_id(BookingDateAndTime booking_id) {
		this.book_id = booking_id;
	}






	public int getSeat_id() {
		return seat_id;
	}


	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

     


	public User getUser_id() {
		return user_id;
	}


	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}


	


	


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}


	


	


	public String getSeatbooked() {
		return seatbooked;
	}






	public void setSeatbooked(String seatbooked) {
		this.seatbooked = seatbooked;
	}






	public BookingDateAndTime getBook_id() {
		return book_id;
	}






	public void setBook_id(BookingDateAndTime book_id) {
		this.book_id = book_id;
	}






	@Override
	public String toString() {
		return "BookingSeat [seat_id=" + seat_id + ", totalprice=" + totalprice + ", seatbooked=" + seatbooked
				+ ", user_id=" + user_id + ", booking_id=" + book_id + "]";
	}
	
	
     
}
