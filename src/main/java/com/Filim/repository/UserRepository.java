package com.Filim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Filim.Entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

	
	List<User> findByEmailAndPassword(String email,String Password);
	
	
	User findByEmail(String email);
	
	
	
}
