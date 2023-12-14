package com.Filim.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Filim.Entity.Movie;
import com.Filim.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movierepository;
	
	
	
	public void saveMovie(Movie moviedata) {
		movierepository.save(moviedata);
	}
	
	
	public List<Movie> getMovieData(String type){
		return movierepository.findByType(type);
	}
	
	public List<Movie> getAllMovieData(String category,String type){
		return movierepository.findByNameAndType(category,type);
	}
	
	
}
