package com.cg.omts.service;

import java.util.List;

import com.cg.omts.entity.Theatre;


public interface TheatreService {
	
	public List<Theatre> findAllTheatre();
	
	public Theatre updateTheatre(Theatre theatre, Long id);
	
	public Theatre addTheatre(Theatre theatre);

	public void deleteTheatre(long theatreId);

	public List<Theatre> findAllTheatreByTheatreNameOrCity(String name, String searchType);

	public Theatre getTheatre(Long id);

	Theatre findById(Long id);

	void deleteAll();

}
