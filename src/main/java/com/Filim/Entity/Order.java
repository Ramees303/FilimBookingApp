package com.Filim.Entity;

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
@Table(name="order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int order_id;
	@Column(name="order_bookingdate")
	private String bookingdate;
	private String moviename;
	private String  showtime;
	private String  showdate;
	private int  totalprice;
	@Column(length = 3000)
	private String  seats;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userid")
	private User user;
	
	
	public Order () {
		System.out.println("Order created");
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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


	public String getShowtime() {
		return showtime;
	}


	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}


	public String getShowdate() {
		return showdate;
	}


	public void setShowdate(String showdate) {
		this.showdate = showdate;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(Integer integer) {
		this.totalprice = integer;
	}


	public String getSeats() {
		return seats;
	}


	public void setSeats(String seats) {
		this.seats = seats;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", bookingdate=" + bookingdate + ", moviename=" + moviename
				+ ", showtime=" + showtime + ", showdate=" + showdate + ", totalprice=" + totalprice + ", seats="
				+ seats + ", user=" + user + "]";
	}
	
	
	
}
