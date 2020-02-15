package com.sapient.assessment.movieservice.domain;

import java.util.List;

public class MoviesDO {
	
	private List<Film> results;
	private int count;
	
	public MoviesDO() {
		super();
	}
	
	
	public MoviesDO(List<Film> films, int count) {
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
