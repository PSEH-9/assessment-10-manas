package com.sapient.assessment.films.controller.mapper;

import java.util.List;

import com.sapient.assessment.films.domain.FilmsDO;
import com.sapient.assessment.films.dto.FilmsDTO;
import com.sapient.assessment.vehicles.domain.Film;

public class FilmsMapper {
	
	public static FilmsDTO makePlanetsDTO(FilmsDO filmsDO,String name)
	{
		
		List<Film> results = filmsDO.getResults();
		
		FilmsDTO.FilmsDTOBuilder planetBuilder = FilmsDTO.newBuilder();
		planetBuilder.name(name);
		planetBuilder.films(results.get(0).getFilms());
		planetBuilder.count(filmsDO.getCount());
		//planetBuilder.type(filmsDO)
		return planetBuilder.build();
	}
}
