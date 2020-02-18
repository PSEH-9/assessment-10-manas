package com.sapient.assessment.vehicles.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {
	
	@JsonProperty("title")
	private String name;
	
	@JsonProperty("url")
	private String films;

	
	public Film() {
		super();
	}

	public Film(String name,String films) {
		this.name=name;
		this.films=films;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilms() {
		return films;
	}

	public void setFilms(String films) {
		this.films = films;
	}
	
	
}
