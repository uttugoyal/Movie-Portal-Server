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

import com.cg.omts.entity.Theatre;
import com.cg.omts.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	private TheatreService theatreService;

	@GetMapping(value="",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Theatre> getAll() {
		return  theatreService.findAllTheatre();
	}
	
	@PostMapping(value="/add")
	public Theatre postCustomer(@RequestBody Theatre theatre) {
		return theatreService.addTheatre(theatre);
	}
	
	@GetMapping(value="/edit/{id}")
	public Theatre postCustomer(@PathVariable Long id) {
		return theatreService.getTheatre(id);
	}
	
	@PostMapping(value="/edit/{id}")
	public ResponseEntity<Theatre> postTheatre(@RequestBody Theatre theatre, @PathVariable Long id) {
		if(theatreService.findById(id) != null) {
		  return new ResponseEntity<>(theatreService.updateTheatre(theatre, id), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


	@GetMapping(value="/find/{name}/{searchType}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Theatre> findByLastName(@PathVariable String name, @PathVariable String searchType) {
		if(name != null && searchType != null) {
			return	theatreService.findAllTheatreByTheatreNameOrCity(name.trim(), searchType);
		}
		return null;
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> deleteTheatre(@PathVariable long id){
		theatreService.deleteTheatre(id);
		return new ResponseEntity<>("Records has been deleted!", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String> deleteAll(){
		theatreService.deleteAll();
		return new ResponseEntity<>("Records has been deleted!", HttpStatus.OK);
	}
	
}
