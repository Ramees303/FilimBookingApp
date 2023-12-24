package com.Filim.ServiceDBIntegerationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Filim.FilimBookingAppApplication;
import com.Filim.Entity.User;
import com.Filim.Service.UserService;
import com.Filim.repository.UserRepository;

/***Database Integeration Testing using H2 **/

@PropertySource("/application.properties")
@SpringBootTest(classes=FilimBookingAppApplication.class)
public class UserServiceTest2 {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private User user;
	
	@BeforeEach
	public void insertUserIntoDB() {
		jdbc.execute("insert into user_data(id,name,email,password,security_question,security_answer)"
				+ "values(1,'draco','d@gmail.com','123','dummyquestion','dummy');");
	}
	
	@BeforeEach
	public void addDataToUser() {
		user=new User();
	    
		user.setEmail("d@gmail.com");
		user.setSecurity_question("dummyquestion");
		user.setSecurity_answer("dummy");
		user.setPassword("123");
	}
	
	
	@DisplayName("checkingUserLogin")
	@Test
	public void checkingUserloginDbTest1() {
		
		int i=userService.checkUserLogin("d@gmail.com", "123");
		assertEquals(1, i);
		
	}
	
	@DisplayName("checkingresetUserpassword")
	@Test
	public void checkingresetUserPassword() {
		int num=userService.resetUserPassword(user);
		assertEquals(1,num);
	}
	
	@DisplayName("checkinggetUserdata")
	@Test
	public void checkinggetUserdataDbTest1() {
		user=userService.getUserdata("d@gmail.com");
		assertEquals(1, user.getId());
		assertEquals("draco",user.getName());
		assertEquals("dummyquestion",user.getSecurity_question());
	}
	
	
	
	
	@AfterEach
	public void deleteDataFromDB() {
		jdbc.execute("delete from user_data");
	}
	
	
	

}
