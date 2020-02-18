package com.sapient.assessment.starwarmovies.service;

import com.sapient.assessment.starwarmovies.domain.StarWarMoviesDO;


public interface StarWarMoviesService {
	
	
	public StarWarMoviesDO findByName(String type,String name) throws Exception;
}
