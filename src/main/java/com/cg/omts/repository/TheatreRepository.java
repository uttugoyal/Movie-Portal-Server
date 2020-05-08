package com.cg.omts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.omts.entity.Theatre;

@Repository
public interface TheatreRepository extends CrudRepository<Theatre, Long> {
    Theatre findByTheatreId(Long theatreId);
    Theatre findByTheatreNameAndTheatreCity(String theatreName, String theatreCity);
	void deleteByTheatreId(long theatreId);
	List<Theatre> findAllByTheatreNameContainingIgnoreCase(String name);
	List<Theatre> findAllByTheatreCityContainingIgnoreCase(String city);
}
