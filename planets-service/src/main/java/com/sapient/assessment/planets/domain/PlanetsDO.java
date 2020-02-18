package com.sapient.assessment.planets.domain;

import java.util.List;

public class PlanetsDO {
	
	private List<Film> results;
	private int count;
	
	public PlanetsDO() {
		super();
	}
	
	
	public PlanetsDO(List<Film> films, int count) {
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
