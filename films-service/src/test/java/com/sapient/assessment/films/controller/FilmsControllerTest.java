package com.sapient.assessment.films.controller;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sapient.assessment.films.domain.FilmsDO;
import com.sapient.assessment.films.service.FilmsService;
import com.sapient.assessment.vehicles.domain.Film;

@RunWith(SpringRunner.class)
@WebMvcTest
public class FilmsControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	FilmsService filmsService;
	
	@Test
	public void getFilmsByNameTest() throws Exception
	{
		List<Film> films = new ArrayList<Film>();
		films.add(new Film("A New Hope","https://swapi.co/api/films/1/"));
		
		FilmsDO filmsDO = new FilmsDO(films, 1);
		
		Mockito.when(filmsService.findByName("A New Hope")).thenReturn(filmsDO);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/films/A New Hope"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json("{\"name\":\"A New Hope\",\"films\":[\"https://swapi.co/api/films/1/\"],\"count\":1}"));
	}
	
	@Test
	public void getFilmsByNameNotFoundTest() throws Exception
	{
		List<Film> films = new ArrayList<Film>();
		films.add(new Film("A New Hope","https://swapi.co/api/films/1/"));
		
		FilmsDO filmsDO = new FilmsDO(films, 1);
		
		Mockito.when(filmsService.findByName("A New Hope")).thenReturn(filmsDO);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/films/A New Hope"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json("{\"name\":\"A New Hope\",\"films\":[\"https://swapi.co/api/films/1/\"],\"count\":1}"));
	}

}
