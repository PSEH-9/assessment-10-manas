package com.sapient.assessment.movieservice.controller;

import java.util.List;

import com.sapient.assessment.movieservice.domain.Film;
import com.sapient.assessment.movieservice.domain.MoviesDO;
import com.sapient.assessment.movieservice.dto.MoviesDTO;

public class MoviesMapper {
	
	public static MoviesDTO makeMoviesDTO(MoviesDO moviesDO,String name)
	{
		
		List<Film> results = moviesDO.getResults();
		
		MoviesDTO.MoviesDTOBuilder moviewDTOtBuilder = MoviesDTO.newBuilder();
		moviewDTOtBuilder.name(name);
		moviewDTOtBuilder.films(results.get(0).getFilms());
		moviewDTOtBuilder.count(moviesDO.getCount());
		return moviewDTOtBuilder.build();
	}
}
