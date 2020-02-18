package com.sapient.assessment.vehicles.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assessment.vehicles.controller.mapper.VehiclesMapper;
import com.sapient.assessment.vehicles.dto.VehiclesDTO;
import com.sapient.assessment.vehicles.service.VehiclesService;

/**
 * @author Manas Nanda
 *  All operations with a Vehicles will be routed by this controller.
 * **/
@RestController
public class VehiclesController {
	
	Logger log = LoggerFactory.getLogger(VehiclesController.class);
	
	@Autowired
	VehiclesService vehicleService;
		
	@GetMapping("/v1/vehicles/{name}")
	public VehiclesDTO viewPlanetByName(@PathVariable("name") String name) throws Exception {
		log.info("Vehicles Controller...."+name);
		return VehiclesMapper.makePlanetsDTO(vehicleService.findByName(name),name);
		
	}

}
