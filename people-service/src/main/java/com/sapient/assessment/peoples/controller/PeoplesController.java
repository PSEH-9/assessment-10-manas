package com.sapient.assessment.peoples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assessment.peoples.controller.mapper.PeoplesMapper;
import com.sapient.assessment.peoples.dto.PeoplesDTO;
import com.sapient.assessment.peoples.service.PeoplesService;

/**
 * @author Manas Nanda
 *  All operations with a Vehicles will be routed by this controller.
 * **/
@RestController
public class PeoplesController {
	
	Logger log = LoggerFactory.getLogger(PeoplesController.class);
	
	@Autowired
	PeoplesService peoplesService;
		
	@GetMapping("/v1/people/{name}")
	public PeoplesDTO viewPlanetByName(@PathVariable("name") String name) throws Exception {
		log.info("Peoples Controller...."+name);
		return PeoplesMapper.makePlanetsDTO(peoplesService.findByName(name),name);
		
	}

}
