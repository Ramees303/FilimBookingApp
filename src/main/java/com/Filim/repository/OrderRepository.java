package com.Filim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Filim.Entity.Order;
import com.Filim.Entity.User;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	
	List<Order> findByUser(User user);
	
	
	
}
