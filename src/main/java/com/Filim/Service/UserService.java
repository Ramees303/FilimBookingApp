package com.Filim.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Filim.Entity.Movie;
import com.Filim.Entity.User;
import com.Filim.repository.MovieRepository;
import com.Filim.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	

	
	public User saveUser(User user) throws RuntimeException {
		if(user==null) {
			throw new RuntimeException("The user is null");
		}
	
		String encryptpassword=bcrypt.encode(user.getPassword());
		user.setPassword(encryptpassword);
		return userRepository.save(user);
				
	}
	
	
	public int checkUserLogin(String email,String password) throws RuntimeException {
		
		if(email==null) {
			throw new RuntimeException("The email is null");
		}
		
		if(password==null) {
			throw new RuntimeException("The password is null");
		}
	
		User user=userRepository.findByEmail(email);
		
		bcrypt.matches(password, user.getPassword());
		
		return 1;
	}
	
	
	
	public int resetUserPassword(User userdata) throws RuntimeException {
		
		if(userdata==null) {
			throw new RuntimeException("The user is null");
		}
		User user=userRepository.findByEmail(userdata.getEmail());
		
		if(user.getSecurity_question().equals(userdata.getSecurity_question())) {
			if(user.getSecurity_answer().equals(userdata.getSecurity_answer())) {
				     
			         user.setPassword(bcrypt.encode(userdata.getPassword()));
			         userRepository.save(user);
			         return 1;
			}
		}
	
		
		return 0;
	}
	
	
	public User getUserdata(String email)throws RuntimeException {
		if(email==null) {
			throw new RuntimeException("The email from getUserdata is null");
		}
		return userRepository.findByEmail(email);
	}
	
	
	
}
