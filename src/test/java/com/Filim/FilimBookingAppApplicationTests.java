package com.Filim;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Filim.Entity.Order;

@SpringBootTest
class FilimBookingAppApplicationTests {

	@Autowired
	private Order order;
	
	@Autowired
	private ApplicationContext context;
	
	
	
	
	@DisplayName("Testing Order bean is prototype")
	@Test
	void orderTest() {
		Order orderbean=context.getBean(Order.class);
		assertNotSame(order, orderbean,"The order bean is singleton");
	}
	
	
	
	@DisplayName("Testing BCryptPasswordEncoder bean is prototype")
	@Test
	void bcryptTest() {
		BCryptPasswordEncoder bcrypt=(BCryptPasswordEncoder) context.getBean("bcryptencoder");
		BCryptPasswordEncoder bcrypt1=new BCryptPasswordEncoder();
		assertNotSame(bcrypt, bcrypt1,"The bcryptencoder bean is singleton");
		
	}

}
