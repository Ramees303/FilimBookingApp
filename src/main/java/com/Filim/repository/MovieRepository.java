package com.Filim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Filim.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	
	Movie findByName(String name);
	

	
	@Query(value="select * from movie where category=?1 and type=?2 limit 4",nativeQuery = true)
	List<Movie> findByNameAndType(String category,String type);
	
	
	@Query(value="select * from Movie  where type=?1 limit 4",nativeQuery=true)
	 List<Movie> findByType(String type);
	
	 
	 
	
	
	
}
