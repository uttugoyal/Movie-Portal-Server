package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omts.entity.Movie;
import com.cg.omts.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping(value="",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getAll() {
		return  movieService.findAllMovie();
	}
	
	@PostMapping(value="/add")
	public Movie postCustomer(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@PostMapping(value="/edit/{id}")
	public void postCustomer(@RequestBody Movie movie, @PathVariable Long id) {
		movieService.updateMovie(movie, id);
	}


	@GetMapping(value="/find/{name}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> findByLastName(@PathVariable String name) {
		return	movieService.findAllMovieByMovieName(name);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable long id){
		movieService.deleteMovie(id);
		return new ResponseEntity<>("Records has been deleted!", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String> deleteAll(){
		movieService.deleteAll();
		return new ResponseEntity<>("Records has been deleted!", HttpStatus.OK);
	}
	
	 @GetMapping(value = "/edit/{id}")
	  public Movie findById(@PathVariable Long id) {
	    return movieService.findById(id);
	  }
}
