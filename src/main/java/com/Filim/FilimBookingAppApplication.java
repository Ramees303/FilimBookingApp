package com.Filim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Filim.Entity.Order;

@SpringBootApplication
public class FilimBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilimBookingAppApplication.class, args);
	}
	
	@Bean
	@Scope(value="prototype")
    public Order order() { 
		return new Order();
	}
	
	@Bean(name = "bcryptencoder")
	@Scope(value = "prototype")
	public BCryptPasswordEncoder bcrypt() {
		return new BCryptPasswordEncoder();
	}

}
