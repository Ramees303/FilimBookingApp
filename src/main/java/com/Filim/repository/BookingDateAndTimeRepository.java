package com.Filim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Filim.Entity.BookingDateAndTime;

@Repository
public interface BookingDateAndTimeRepository extends JpaRepository<BookingDateAndTime, Integer> {

	
	   @Query(value="select booking_id from bookingdateandtime  where moviename=?1 and date=?2 and time=?3",nativeQuery = true)
	  List<Integer> getBookingid(String moviename,String date,String time);

	
	

}
