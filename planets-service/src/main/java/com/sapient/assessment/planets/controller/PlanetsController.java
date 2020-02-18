package com.sapient.assessment.planets.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assessment.planets.controller.mapper.PlanetsMapper;
import com.sapient.assessment.planets.dto.PlanetsDTO;
import com.sapient.assessment.planets.service.PlanetsService;

/**
 * @author Manas Nanda
 *  All operations with a planets will be routed by this controller.
 * **/
@RestController
public class PlanetsController {
	
	Logger log = LoggerFactory.getLogger(PlanetsController.class);
	
	@Autowired
	PlanetsService planetService;
		
	@GetMapping("/v1/planets/{name}")
	public PlanetsDTO viewPlanetByName(@PathVariable("name") String name) throws Exception {
		log.info("Planets Controller...."+name);
		return PlanetsMapper.makePlanetsDTO(planetService.findByName(name),name);
		
	}

}
