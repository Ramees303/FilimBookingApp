package com.Filim.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class UserServiceTest {
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	public void insertUserIntoDB() {
		jdbc.execute("insert into user_data(name,email,password,security_question,security_answer)"
				+ "values('draco','d@gmail.com','123','dummyquestion','dummy');");
	}
	
	@BeforeEach
	public void addDataToUser() {
		user=new User();
	    user.setName("dummy");
		user.setEmail("dummy@gmail.com");
		user.setSecurity_question("dummyquestion");
		user.setSecurity_answer("dummy");
		user.setPassword("456");
	}
	
	
	@DisplayName("checkingSaveUser")
	@Test
	public void checkingSaveUser() {
		assertTrue(userService.saveUser(user),"The user is not saved");
		assertFalse(userService.saveUser(null));
		User user=userRepository.findByEmail("dummy@gmail.com");
		assertEquals("dummy@gmail.com", user.getEmail());
	}
	
	
	
	@DisplayName("checkingUserLogin")
	@Test
	public void checkingUserlogin() {
		
		int i=userService.checkUserLogin("d@gmail.com", "123");
		assertEquals(1, i);
		
	}
	
	@DisplayName("checkingresetUserpassword")
	@Test
	public void checkingresetUserPassword() {
		userService.saveUser(user);
		int num=userService.resetUserPassword(user);
		assertEquals(1,num);
	}
	
	@DisplayName("checkinggetUserdata")
	@Test
	public void checkinggetUserdata() {
		user=userService.getUserdata("d@gmail.com");
		assertEquals("draco",user.getName());
		assertEquals("d@gmail.com",user.getEmail());
		assertEquals("dummyquestion",user.getSecurity_question());
	}
	
	
	
	
	@AfterEach
	public void deleteDataFromDB() {
		jdbc.execute("delete from user_data");
	}
	
	
	

}
