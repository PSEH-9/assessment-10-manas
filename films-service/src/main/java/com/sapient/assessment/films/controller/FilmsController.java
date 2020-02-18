package com.sapient.assessment.films.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assessment.films.controller.mapper.FilmsMapper;
import com.sapient.assessment.films.dto.FilmsDTO;
import com.sapient.assessment.films.service.FilmsService;

/**
 * @author Manas Nanda
 *  All operations with a Films will be routed by this controller.
 * **/
@RestController
public class FilmsController {
	
	Logger log = LoggerFactory.getLogger(FilmsController.class);
	
	@Autowired
	FilmsService filmService;
		
	@GetMapping("/v1/films/{name}")
	public FilmsDTO viewPlanetByName(@PathVariable("name") String name) throws Exception {
		log.info("Vehicles Controller...."+name);
		return FilmsMapper.makePlanetsDTO(filmService.findByName(name),name);
		
	}

}
