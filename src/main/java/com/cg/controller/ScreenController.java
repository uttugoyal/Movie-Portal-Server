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

import com.cg.omts.entity.Screen;
import com.cg.omts.service.ScreenService;

@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService screenService;

	@GetMapping(value="",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Screen> getAll() {
		return  screenService.findAllScreen();
	}
	
	@PostMapping(value="/add")
	public Screen postCustomer(@RequestBody Screen screen) {
		return screenService.addScreen(screen);
	}
	
	@PostMapping(value="/edit/{id}")
	public void postCustomer(@RequestBody Screen screen, @PathVariable Long id) {
		screenService.updateScreen(screen, id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteScreen(@PathVariable long id){
		screenService.deleteScreen(id);
		return new ResponseEntity<>("Records has been deleted!", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String> deleteScreen(){
		screenService.deleteAllScreen();
		return new ResponseEntity<>("Records has been deleted!", HttpStatus.OK);
	}
	
	 @GetMapping(value = "/edit/{id}")
	  public Screen findByAge(@PathVariable Long id) {
	    return screenService.findById(id);
	  }
	 
}
