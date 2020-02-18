package com.sapient.assessment.films.service;

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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sapient.assessment.films.domain.FilmsDO;
import com.sapient.assessment.films.exceptions.FilmsNotFoundException;
import com.sapient.assessment.vehicles.domain.Film;

/**
 * Service to have business logic for some planets specific things.
 * <p/>
 */

@Service
public class FilmsServiceImpl implements FilmsService{

	Logger log = LoggerFactory.getLogger(FilmsServiceImpl.class);
	
	@Value("${swapi.planets}")
	private String SWAPI_PLANETS;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public FilmsDO findByName(String name) throws Exception {
		
		FilmsDO planets = getFilms();	
		
		
			if(planets==null || planets.getResults()==null)
			{
				throw new FilmsNotFoundException("Planet not found by name"+name);
			}
			else
			{
				List<Film> films = planets.getResults()
				.stream().filter(f->name.equals(f.getName()))
				.collect(Collectors.toList());
				if(films.size()==0)
				{
					throw new FilmsNotFoundException("Planet not found by name: "+name);
				}
				planets.setResults(films);
			}
		
		
		return planets;
	}
	
	private FilmsDO getFilms() throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        FilmsDO filmsDO;
		try {
			filmsDO = restTemplate.exchange(SWAPI_PLANETS,
					HttpMethod.GET,
					entity,
					new ParameterizedTypeReference<FilmsDO>() {}).getBody();
		} catch (RestClientException e) {
			log.error("ERROR::",e.getMessage());
			throw new Exception("Films server is unavailable");
		}
		
		return filmsDO;
	}

}
