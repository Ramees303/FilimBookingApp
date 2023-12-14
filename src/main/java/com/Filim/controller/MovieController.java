package com.Filim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Filim.Entity.Movie;
import com.Filim.Service.MovieService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MovieController {

	
	@Autowired 
	private MovieService movieservice;
	
	
	@GetMapping("/movies")
	public String getMovies(Model model,HttpSession session) {
		List<Movie> actionmovie=movieservice.getAllMovieData("Action","Available");
		List<Movie> thrillermovie=movieservice.getAllMovieData("Thriller","Available");
		List<Movie> romancemovie=movieservice.getAllMovieData("Romance","Available");
		List<Movie> adventuremovie=movieservice.getAllMovieData("Adventure","Available");
		
		System.out.println(actionmovie);
		model.addAttribute("actionmovie", actionmovie);
		model.addAttribute("thrillermovie",thrillermovie);
		model.addAttribute("romancemovie",romancemovie);
		model.addAttribute("adventuremovie",adventuremovie);
		
		if(session.getAttribute("email")==null) {
			return "login";
		}
		
		return "movies";
	}
	
	
	
	
	@PostMapping("savemovie")
	public String saveMovie(@ModelAttribute Movie moviedata,Model model) {
	
		movieservice.saveMovie(moviedata);
		model.addAttribute("msg","filim_added");
		return "adminaddmovies";
	}
	
}
