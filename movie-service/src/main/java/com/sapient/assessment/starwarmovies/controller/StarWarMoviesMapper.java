package com.sapient.assessment.starwarmovies.controller;

import com.sapient.assessment.starwarmovies.domain.StarWarMoviesDO;
import com.sapient.assessment.starwarmovies.dto.StarWarMoviesDTO;

public class StarWarMoviesMapper {
	
	public static StarWarMoviesDTO makeStarWarMoviesDTO(StarWarMoviesDO moviesDO,String name)
	{
		
		StarWarMoviesDTO.StarWarMoviesDTOBuilder moviewDTOtBuilder = StarWarMoviesDTO.newBuilder();
		moviewDTOtBuilder.name(name);
		moviewDTOtBuilder.films(moviesDO.getFilms());
		moviewDTOtBuilder.count(moviesDO.getCount());
		moviewDTOtBuilder.type(moviesDO.getType());
		return moviewDTOtBuilder.build();
	}
}
