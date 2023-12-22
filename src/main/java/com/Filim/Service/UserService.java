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
	

	
	public void saveUser(User user) {
	
		String encryptpassword=bcrypt.encode(user.getPassword());
		user.setPassword(encryptpassword);
		userRepository.save(user);
	}
	
	
	public int checkUserLogin(String email,String password) {
		
		
	
		User user=userRepository.findByEmail(email);
		
		bcrypt.matches(password, user.getPassword());
		if(user==null) {
			return 0;
		}
		return 1;
	}
	
	
	
	public int resetUserPassword(User userdata) {
		
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
	
	
	public User getUserdata(String email) {
		return userRepository.findByEmail(email);
	}
	
	
	
}
