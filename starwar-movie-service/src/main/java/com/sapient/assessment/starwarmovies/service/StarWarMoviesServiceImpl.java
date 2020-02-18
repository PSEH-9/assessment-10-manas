package com.sapient.assessment.starwarmovies.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.assessment.starwarmovies.StarWarMovieServiceApplication.FilmsClient;
import com.sapient.assessment.starwarmovies.StarWarMovieServiceApplication.PeoplesClient;
import com.sapient.assessment.starwarmovies.StarWarMovieServiceApplication.PlanetsClient;
import com.sapient.assessment.starwarmovies.StarWarMovieServiceApplication.SpaceshipsClient;
import com.sapient.assessment.starwarmovies.StarWarMovieServiceApplication.SpeciesClient;
import com.sapient.assessment.starwarmovies.StarWarMovieServiceApplication.VehiclesClient;
import com.sapient.assessment.starwarmovies.domain.StarWarMoviesDO;
import com.sapient.assessment.starwarmovies.exception.StarWarMovieNotFoundException;

/**
 * Service to have business logic for some planets specific things.
 * <p/>
 */

@Service
public class StarWarMoviesServiceImpl implements StarWarMoviesService{

	Logger log = LoggerFactory.getLogger(StarWarMoviesServiceImpl.class);
	
	@Autowired
	PlanetsClient planetsClient;
	@Autowired
	VehiclesClient vehiclesClient;
	@Autowired
	PeoplesClient peoplesClient;
	@Autowired
	FilmsClient filmsClient;
	@Autowired
	SpeciesClient speciesClient;
	@Autowired
	SpaceshipsClient spaceshipsClient;
	
	@Override
	public StarWarMoviesDO findByName(String type,String name) throws Exception {
		
		log.info("Fetching movie details of type:"+type+"  and name:"+name);
		StarWarMoviesDO moviesDetails = null;
		
		if("planets".equalsIgnoreCase(type))
		{
			moviesDetails = planetsClient.getPlanetsByName(name);
		}
		else if("vehicles".equalsIgnoreCase(type))
		{
			moviesDetails = vehiclesClient.getVehiclesByName(name);
		}
		else if("peoples".equalsIgnoreCase(type))
		{
			moviesDetails = peoplesClient.getPeoplesByName(name);
		}
		else if("films".equalsIgnoreCase(type))
		{
			moviesDetails = filmsClient.getFilmsByName(name);
		}
		
		else if("species".equalsIgnoreCase(type))
		{
			moviesDetails = speciesClient.getSpeciesByName(name);
		}
		else if("spaceships".equalsIgnoreCase(type))
		{
			moviesDetails = spaceshipsClient.getSpaceshipsByName(name);
		}
		else
		{
			throw new StarWarMovieNotFoundException("Invalid movie type");
		}
		
		if(moviesDetails!=null)
		{
			moviesDetails.setType(type);
		}
		
		return moviesDetails;
	}
	
}
