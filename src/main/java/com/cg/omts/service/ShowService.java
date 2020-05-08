package com.cg.omts.service;

import java.util.List;

import com.cg.model.Show;

public interface ShowService {
	
	public List<Show> findAllShow();
	
	public Show updateShow(Show show);
	
	public void addShow(Show show);

	public void deleteShow(Integer ShowId);

}
