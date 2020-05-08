package com.cg.omts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.omts.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByMovieName(String movieName);
    Movie findByMovieId(long movieId);
	List<Movie> findAllByMovieName(String movie);
}
