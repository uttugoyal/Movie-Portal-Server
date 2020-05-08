package com.cg.omts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.entity.Theatre;
import com.cg.omts.repository.TheatreRepository;
import com.cg.omts.service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	private TheatreRepository  repository;
	
	@Override
	public List<Theatre> findAllTheatre(){
		List<Theatre> list = new ArrayList<>();
		Iterable<Theatre> customers = repository.findAll();
		customers.forEach(list::add);
		return list;
	}
	
	@Override
	public Theatre updateTheatre(Theatre Theatre, Long theatreId) {
		Theatre theatre2 = repository.findByTheatreId(theatreId);
		theatre2.setTheatreName(Theatre.getTheatreName());
		theatre2.setTheatreCity(Theatre.getTheatreCity());
		repository.save(theatre2);
		return theatre2;
	}
	
	@Override
	public Theatre addTheatre(Theatre Theatre) {
         Theatre.setTheatreId(3000 + new Random().nextInt(1000));
          return repository.save(Theatre);
	}
	
	@Override
	public void deleteTheatre(long theatreId) {
		repository.delete(theatreId);
	}

	@Override
	public List<Theatre> findAllTheatreByTheatreNameOrCity(String name, String searchType) {
		if(searchType.equalsIgnoreCase("city")) {
			return	repository.findAllByTheatreCityContainingIgnoreCase(name);
		}else if(searchType.equalsIgnoreCase("name")){
			return	repository.findAllByTheatreNameContainingIgnoreCase(name);
		}
		return null;
	}

	@Override
	public Theatre getTheatre(Long id) {
		return  repository.findByTheatreId(id);
	}
	
	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public Theatre findById(Long id) {
		return repository.findByTheatreId(id);
	}
	
}
