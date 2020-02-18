package com.sapient.assessment.vehicles.service;

import com.sapient.assessment.vehicles.domain.VehiclesDO;
import com.sapient.assessment.vehicles.exceptions.VehiclesNotFoundException;


public interface VehiclesService {
	
	
	public VehiclesDO findByName(String name) throws VehiclesNotFoundException,Exception;
}
