package com.Filim.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Filim.FilimBookingAppApplication;
import com.Filim.Entity.User;
import com.Filim.Service.UserService;
import com.Filim.repository.UserRepository;

@SpringBootTest(classes = FilimBookingAppApplication.class)
public class UserServiceTest {

	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	
	private User user;
	
	
	
	@BeforeEach
	public void beforeEach() {
		user=new User();
		user.setId(1);
		user.setName("David");
		user.setEmail("dummy@gmail.com");
		user.setPassword("12345");
		user.setSecurity_question("What test is this");
		user.setSecurity_answer("mockTest or TestDouble");
	}
	
	
	@DisplayName("saveUserTest-1")
	@Test
	 void saveUserTest1() {
		when(userRepository.save(user)).thenReturn(user);
		
		
		assertThrows(RuntimeException.class,()->userService.saveUser(null),"The Exception is not thrown");
		assertDoesNotThrow(()->userService.saveUser(user),"The Exception is thrown");

	}
	
	@DisplayName("saveUserTest-2")
	@Test
	void checkingExceptionOnDBsaveUserTest() {
		
		doThrow(new RuntimeException()).when(userRepository).save(user);
		
	    assertThrows(RuntimeException.class,()->{userService.saveUser(user);},"The exception is not thrown");
		
		
	}
	
	@DisplayName("checkUserLogin Test-1")
	@Test
	void checkUserLoginTest() {
		when(userRepository.findByEmail("dummy@gmail.com")).thenReturn(user);
		
		assertEquals(1,userService.checkUserLogin(user.getEmail(),user.getPassword()),"The user is null");
		assertThrows(RuntimeException.class,()->userService.checkUserLogin(null, "1234"),"The Exception is thrown");
		assertThrows(RuntimeException.class,()->userService.checkUserLogin("email", null),"The Exception is thrown");
		assertThrows(RuntimeException.class,()->userService.checkUserLogin(null, null),"The Exception is thrown");
		assertDoesNotThrow(()->userService.checkUserLogin(user.getEmail(),user.getPassword()));
		
	}
	
	@DisplayName("checkUserLogin Test-2")
	@Test
	void checkingExceptionOnUserLogin(){
		doThrow(new RuntimeException()).when(userRepository).findByEmail("dummy@gmail.com");
		assertThrows(RuntimeException.class,()->userService.checkUserLogin("dummy@gmail.com","12345"),"The Exception is thrown");
		
	}
	
		
	@DisplayName("resetUserPassword Test1")
	@Test
	void resetUserPasswordTest() {
		when(userRepository.findByEmail("dummy@gmail.com")).thenReturn(user);
		assertEquals(1,userService.resetUserPassword(user),"The user is null");
		assertThrows(Exception.class,()->userService.resetUserPassword(null),"The Exception is thrown");
		assertDoesNotThrow(()->userService.resetUserPassword(user));
	}

	
	@DisplayName("resetUserPassword Test2")
	@Test
	void checkingExceptiOnfindByEmailInResetUserPasswordTest() {
		doThrow(new RuntimeException()).when(userRepository).findByEmail("dummy@gmail.com");
		assertThrows(RuntimeException.class,()->userService.resetUserPassword(user),"The Exception is thrown");
		
	}

	
	@DisplayName("resetUserPassword Test3")
	@Test
	void checkingExceptiOnDbSaveInResetUserPasswordTest() {
		doThrow(new RuntimeException()).when(userRepository).save(user);
		assertThrows(RuntimeException.class,()->userService.resetUserPassword(user),"The Exception is thrown");
		
	}
	
	@DisplayName("getUserdata Test1")
	@Test
	void getUserdataTest() {
		when(userRepository.findByEmail("dummy@gmail.com")).thenReturn(user);
		assertSame(user, userService.getUserdata("dummy@gmail.com"));
		assertThrows(RuntimeException.class,()->userService.getUserdata(null));
		assertDoesNotThrow(()->userService.getUserdata("harry"));
	}
	
	@DisplayName("getUserdata  Test2")
	@Test
	void checkingExceptiOnfindByEmailIngetUserdataTest() {
		doThrow(new RuntimeException()).when(userRepository).findByEmail("dummy@gmail.com");
		assertThrows(RuntimeException.class,()->userService.resetUserPassword(user),"The Exception is thrown");
		
	}
	
}
