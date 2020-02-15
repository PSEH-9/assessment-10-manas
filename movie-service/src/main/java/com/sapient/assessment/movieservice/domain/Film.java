package com.sapient.assessment.movieservice.domain;

import java.util.List;

public class Film {
	
	private String name;
	private List<String> films;

	
	public Film() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	
}
