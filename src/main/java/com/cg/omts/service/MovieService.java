package com.cg.omts.service;

import java.util.List;

import com.cg.omts.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAllMovie();
	
	public  List<Movie> findAllMovieByMovieName(String movie1);

	public Movie updateMovie(Movie movie, Long movieId);
	
	public Movie addMovie(Movie movie);

	public void deleteMovie(Long movieId);

	public void deleteAll();

	public Movie findById(Long id);

}
