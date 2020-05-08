package com.cg.omts.service;

import java.util.List;

import com.cg.omts.entity.Screen;

public interface ScreenService {
	
	public List<Screen> findAllScreen();
	
	public Screen updateScreen(Screen Screen, long screenId);
	
	public Screen addScreen(Screen screen);

	public void deleteScreen(long screenId);

	public void deleteAllScreen();

	public Screen findById(Long id);

}
