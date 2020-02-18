package com.sapient.assessment.starwarmovies.domain;

import java.util.List;

public class StarWarMoviesDO {
	
	private String type;
	private List<String> films;
	private int count;
	
	public StarWarMoviesDO() {
		super();
	}
	
	
	public StarWarMoviesDO(List<String> films, int count) {
		super();		
		this.films = films;
		this.count = count;
	}


	
	
	public int getCount() {
		return count;
	}


	


	public List<String> getFilms() {
		return films;
	}


	public void setFilms(List<String> films) {
		this.films = films;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
