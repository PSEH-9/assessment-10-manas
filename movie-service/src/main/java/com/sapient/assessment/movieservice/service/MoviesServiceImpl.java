package com.sapient.assessment.movieservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sapient.assessment.movieservice.domain.Film;
import com.sapient.assessment.movieservice.domain.MoviesDO;
import com.sapient.assessment.movieservice.exception.MoviesNotFoundException;

/**
 * Service to have business logic for some planets specific things.
 * <p/>
 */

@Service
public class MoviesServiceImpl implements MoviesService{

	Logger log = LoggerFactory.getLogger(MoviesServiceImpl.class);
	
	@Value("${sw.api}")
	private String SW_API;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public MoviesDO findByName(String type,String name) throws Exception {
		
		MoviesDO movieDO = getMovies(type);	
		
		
			if(movieDO==null || movieDO.getResults()==null)
			{
				throw new MoviesNotFoundException("Movie not found by name"+name);
			}
			else
			{
				List<Film> films = movieDO.getResults()
				.stream().filter(f->name.equals(f.getName()))
				.collect(Collectors.toList());
				if(films.size()==0)
				{
					throw new MoviesNotFoundException("Planet not found by name: "+name);
				}
				movieDO.setResults(films);
			}
		
		
		return movieDO;
	}
	
	private MoviesDO getMovies(String type) throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        MoviesDO moviesDO=null;
		try {
			moviesDO = restTemplate.exchange(SW_API+"/"+type,
					HttpMethod.GET,
					entity,
					new ParameterizedTypeReference<MoviesDO>() {}).getBody();
		} catch (HttpStatusCodeException ex) {
			log.error("ERROR::",ex.getRawStatusCode());
			throw new Exception("Type not found");
		}catch (RestClientException e) {
			log.error("ERROR::",e);
			throw new Exception("SWAPI server is down");
		}
		
		return moviesDO;
	}

}
