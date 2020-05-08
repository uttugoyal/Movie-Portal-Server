package com.cg.model;

import java.time.LocalDate;
import java.util.Random;

public class Movie {

	private Integer movieId;
	private Integer movieLength;
	private Integer theaterId;
	private String movieName;
	private String movieDirector;
	private String movieGenre;
	private LocalDate movieReleaseDate;
	private String[] languages;

	public Movie(Integer theaterId, Integer movieLength, String movieName, String movieDirector, String movieGenre,
			LocalDate movieReleaseDate, String[] languages) {

		this.theaterId = theaterId;
		this.movieId = movieIdGenerator();
		this.movieLength = movieLength;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.languages = languages;
	}

	public Integer movieIdGenerator() {
		return 3000 + new Random().nextInt(1000);
	}

	public Integer getMovieLength() {
		return movieLength;
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public String[] getLanguages() {
		return languages;
	}

	public Integer getMovieId() {
		return movieId;
	}
}
