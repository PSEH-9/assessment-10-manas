package com.sapient.assessment.planets.service;

import com.sapient.assessment.planets.domain.PlanetsDO;
import com.sapient.assessment.planets.exceptions.PlanetNotFoundException;


public interface PlanetsService {
	
	
	public PlanetsDO findByName(String name) throws PlanetNotFoundException,Exception;
}
