package com.sapient.assessment.vehicles.controller.mapper;

import java.util.List;

import com.sapient.assessment.vehicles.domain.Film;
import com.sapient.assessment.vehicles.domain.VehiclesDO;
import com.sapient.assessment.vehicles.dto.VehiclesDTO;

public class VehiclesMapper {
	
	public static VehiclesDTO makePlanetsDTO(VehiclesDO planetsDO,String name)
	{
		
		List<Film> results = planetsDO.getResults();
		
		VehiclesDTO.VehiclesDTOBuilder planetBuilder = VehiclesDTO.newBuilder();
		planetBuilder.name(name);
		planetBuilder.films(results.get(0).getFilms());
		planetBuilder.count(planetsDO.getCount());
		return planetBuilder.build();
	}
}
