package com.sapient.assessment.planets.controller.mapper;

import java.util.List;

import com.sapient.assessment.planets.domain.Film;
import com.sapient.assessment.planets.domain.PlanetsDO;
import com.sapient.assessment.planets.dto.PlanetsDTO;

public class PlanetsMapper {
	
	public static PlanetsDTO makePlanetsDTO(PlanetsDO planetsDO,String name)
	{
		
		List<Film> results = planetsDO.getResults();
		
		PlanetsDTO.PlanetsDTOBuilder planetBuilder = PlanetsDTO.newBuilder();
		planetBuilder.name(name);
		planetBuilder.films(results.get(0).getFilms());
		planetBuilder.count(planetsDO.getCount());
		return planetBuilder.build();
	}
}
