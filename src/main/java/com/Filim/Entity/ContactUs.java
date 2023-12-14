package com.Filim.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contactus")
public class ContactUs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contact_id;
	private String email;
	@Column(length = 2000)
	private String message;
	
	
	public ContactUs() {
		System.out.println(this.getClass().getSimpleName());
	}


	public int getContact_id() {
		return contact_id;
	}


	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
