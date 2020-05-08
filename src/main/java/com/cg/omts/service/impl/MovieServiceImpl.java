package com.cg.omts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.entity.Movie;
import com.cg.omts.repository.MovieRepository;
import com.cg.omts.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository  repository;
	
	@Override
	public List<Movie> findAllMovie(){
		List<Movie> list = new ArrayList<>();
		Iterable<Movie> customers = repository.findAll();
		customers.forEach(list::add);
		return list;
	}
	
	@Override
	public  List<Movie> findAllMovieByMovieName(String movie){
		return	repository.findAllByMovieName(movie);
	}

	@Override
	public Movie updateMovie(Movie movie, Long movieId) {
		Movie movie2 = repository.findByMovieId(movieId);
		movie2.setMovieName(movie.getMovieName());
		repository.save(movie2);
		return movie2;
	}
	
	@Override
	public Movie addMovie(Movie movie) {
         movie.setMovieId(3000 + new Random().nextInt(1000));
         return repository.save(movie);
	}

	@Override
	public void deleteMovie(Long movieId) {
		repository.delete(repository.findByMovieId(movieId));
	}
	
	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public Movie findById(Long id) {
		return repository.findByMovieId(id);
	}

}
