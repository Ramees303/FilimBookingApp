package com.Filim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Filim.Entity.BookingSeat;

@Repository
public interface BookingSeatRepository extends JpaRepository<BookingSeat, Integer>{

	
	@Query(value="select seatbooked from booking_seat  where booking_id in ?1 ",nativeQuery = true)
	List<String> getseatdata(List<Integer> bookingid);
	
}
