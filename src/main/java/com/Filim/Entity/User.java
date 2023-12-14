package com.Filim.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20,nullable = false)
	private String name;
	@Column(length = 20,nullable = false,unique = true)
	private String email;
	@Column(length = 20,nullable = false)
	private String password;
	@Column(length = 20,nullable = false)
	private String security_question;
	@Column(length = 20,nullable = false)
	private String security_answer;
	
	@OneToMany(mappedBy = "user_id")
	private List<BookingSeat> userseatbooking;
	
	@OneToMany(mappedBy = "user")
	private List<Order> order_id;
	
	
	
	public User() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	
	
	












	public List<Order> getOrder_id() {
		return order_id;
	}















	public void setOrder_id(List<Order> order_id) {
		this.order_id = order_id;
	}















	public List<BookingSeat> getUserseatbooking() {
		return userseatbooking;
	}




	public void setUserseatbooking(List<BookingSeat> userseatbooking) {
		this.userseatbooking = userseatbooking;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

	public String getSecurity_answer() {
		return security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", security_question=" + security_question + ", security_answer=" + security_answer
				 +"]";
	}

	
	
	

}
