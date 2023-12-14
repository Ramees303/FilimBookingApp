package com.Filim.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="bookingdateandtime")
public class BookingDateAndTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int booking_id;
	private String date;
	private String time;
	private String bookingdate;
	private String moviename;
	
	@OneToMany(mappedBy = "book_id")
	private List<BookingSeat> booked_seat_id;


	public BookingDateAndTime() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}

	
	

	




	public List<BookingSeat> getBooked_seat_id() {
		return booked_seat_id;
	}









	public void setBooked_seat_id(List<BookingSeat> booked_seat_id) {
		this.booked_seat_id = booked_seat_id;
	}









	public int getBooking_id() {
		return booking_id;
	}


	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	


	public String getBookingdate() {
		return bookingdate;
	}


	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}


	public String getMoviename() {
		return moviename;
	}


	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}





	@Override
	public String toString() {
		return "BookingDateAndTime [booking_id=" + booking_id + ", date=" + date + ", time=" + time + ", currentdate="
				+ bookingdate + ", moviename=" + moviename +  "]";
	}
	
	
	
}
