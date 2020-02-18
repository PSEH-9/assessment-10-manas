package com.sapient.assessment.films.service;

import com.sapient.assessment.films.domain.FilmsDO;
import com.sapient.assessment.films.exceptions.FilmsNotFoundException;


public interface FilmsService {
	
	
	public FilmsDO findByName(String name) throws FilmsNotFoundException,Exception;
}
