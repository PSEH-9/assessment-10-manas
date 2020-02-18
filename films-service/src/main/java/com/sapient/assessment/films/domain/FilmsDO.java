package com.sapient.assessment.films.domain;

import java.util.List;

import com.sapient.assessment.vehicles.domain.Film;

public class FilmsDO {
	
	private List<Film> results;
	
	private int count;
	
	public FilmsDO() {
		super();
	}
	
	
	public FilmsDO(List<Film> films, int count) {
		super();		
		this.results = films;
		this.count = count;
	}


	
	
	public int getCount() {
		return count;
	}


	


	public List<Film> getResults() {
		return results;
	}


	public void setResults(List<Film> results) {
		this.results = results;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
