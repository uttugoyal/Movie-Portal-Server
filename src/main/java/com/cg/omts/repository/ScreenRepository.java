package com.cg.omts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.omts.entity.Screen;

public interface ScreenRepository extends CrudRepository<Screen, Long> {
    public Screen findByScreenId(long screenId);
    public List<Screen> findByTheatreId(long theatreId);
	public void deleteByScreenId(Long screenId);
}
