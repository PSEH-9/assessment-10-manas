package com.sapient.assessment.movieservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assessment.movieservice.dto.MoviesDTO;
import com.sapient.assessment.movieservice.service.MoviesService;

/**
 * @author Manas Nanda
 *  All operations with a movies will be routed by this controller.
 * **/

@RestController
public class MoviesController {

	
	Logger log = LoggerFactory.getLogger(MoviesController.class);
	
	@Autowired
	MoviesService movieService;
		
	@GetMapping("/")
	public MoviesDTO viewPlanetByName(@RequestParam String type, @RequestParam String name) throws Exception {
		log.info("Moview Controller....name:"+name+" type:"+type);
		return MoviesMapper.makeMoviesDTO(movieService.findByName(type,name),name);
		
	}


}
