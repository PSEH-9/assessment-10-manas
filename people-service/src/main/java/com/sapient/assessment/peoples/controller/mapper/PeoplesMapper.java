package com.sapient.assessment.peoples.controller.mapper;

import java.util.List;

import com.sapient.assessment.peoples.domain.PeoplesDO;
import com.sapient.assessment.peoples.dto.PeoplesDTO;
import com.sapient.assessment.vehicles.domain.Film;

public class PeoplesMapper {
	
	public static PeoplesDTO makePlanetsDTO(PeoplesDO planetsDO,String name)
	{
		
		List<Film> results = planetsDO.getResults();
		
		PeoplesDTO.VehiclesDTOBuilder planetBuilder = PeoplesDTO.newBuilder();
		planetBuilder.name(name);
		planetBuilder.films(results.get(0).getFilms());
		planetBuilder.count(planetsDO.getCount());
		return planetBuilder.build();
	}
}
