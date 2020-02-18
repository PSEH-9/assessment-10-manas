package com.sapient.assessment.peoples.service;

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

import com.sapient.assessment.peoples.domain.PeoplesDO;
import com.sapient.assessment.peoples.exceptions.PeoplesNotFoundException;
import com.sapient.assessment.vehicles.domain.Film;

/**
 * Service to have business logic for some planets specific things.
 * <p/>
 */

@Service
public class PeoplesServiceImpl implements PeoplesService{

	Logger log = LoggerFactory.getLogger(PeoplesServiceImpl.class);
	
	@Value("${swapi.peoples}")
	private String SWAPI_PEOPLES;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public PeoplesDO findByName(String name) throws Exception {
		
		PeoplesDO planets = getPlanets();	
		
		
			if(planets==null || planets.getResults()==null)
			{
				throw new PeoplesNotFoundException("Planet not found by name"+name);
			}
			else
			{
				List<Film> films = planets.getResults()
				.stream().filter(f->name.equals(f.getName()))
				.collect(Collectors.toList());
				if(films.size()==0)
				{
					throw new PeoplesNotFoundException("Planet not found by name: "+name);
				}
				planets.setResults(films);
			}
		
		
		return planets;
	}
	
	private PeoplesDO getPlanets() throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        PeoplesDO planetsDO;
		try {
			planetsDO = restTemplate.exchange(SWAPI_PEOPLES,
					HttpMethod.GET,
					entity,
					new ParameterizedTypeReference<PeoplesDO>() {}).getBody();
		} catch (RestClientException e) {
			log.error("ERROR::",e.getMessage());
			throw new Exception("Planet server is down");
		}
		
		return planetsDO;
	}

}
