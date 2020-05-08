package com.cg.omts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omts.entity.Screen;
import com.cg.omts.repository.ScreenRepository;
import com.cg.omts.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService {
	
	@Autowired
	private ScreenRepository  repository;
	
	@Override
	public List<Screen> findAllScreen(){
		List<Screen> list = new ArrayList<>();
		Iterable<Screen> customers = repository.findAll();
		customers.forEach(list::add);
		return list;
	}
	
	@Override
	public Screen updateScreen(Screen screen, long screenId) {
		Screen screen2 = repository.findByScreenId(screenId);
		screen2.setSeatsNum(screen.getSeatsNum());
		repository.save(screen2);
		return screen2;
	}
	
	@Override
	public Screen addScreen(Screen screen) {
         screen.setScreenId(new Random().nextInt(100) * 10000 + screen.getTheatreId());
         return repository.save(screen);
	}

	@Override
	public void deleteScreen(long screenId) {
		repository.delete(screenId);
	}

	@Override
	public void deleteAllScreen() {
		repository.deleteAll();
	}

	@Override
	public Screen findById(Long screenId) {
		return repository.findByScreenId(screenId);
	}

}
