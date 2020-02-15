package com.sapient.assessment.movieservice.service;

import com.sapient.assessment.movieservice.domain.MoviesDO;


public interface MoviesService {
	
	
	public MoviesDO findByName(String type,String name) throws Exception;
}
