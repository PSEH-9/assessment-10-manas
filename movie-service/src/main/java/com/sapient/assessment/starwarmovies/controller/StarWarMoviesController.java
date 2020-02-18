package com.sapient.assessment.starwarmovies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assessment.starwarmovies.dto.StarWarMoviesDTO;
import com.sapient.assessment.starwarmovies.service.StarWarMoviesService;

/**
 * @author Manas Nanda
 *  All operations with a movies will be routed by this controller.
 * **/

@RestController
public class StarWarMoviesController {

	
	Logger log = LoggerFactory.getLogger(StarWarMoviesController.class);
	
	@Autowired
	StarWarMoviesService starWarMovieService;
		
	@GetMapping("/")
	public StarWarMoviesDTO viewPlanetByName(@RequestParam String type, @RequestParam String name) throws Exception {
		log.info("Star War Movies Controller....name:"+name+" type:"+type);
		
		return StarWarMoviesMapper.makeStarWarMoviesDTO(starWarMovieService.findByName(type,name),name);
		
	}


}
