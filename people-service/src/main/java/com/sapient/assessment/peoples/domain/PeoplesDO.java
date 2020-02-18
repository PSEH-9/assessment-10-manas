package com.sapient.assessment.peoples.domain;

import java.util.List;

import com.sapient.assessment.vehicles.domain.Film;

public class PeoplesDO {
	
	private List<Film> results;
	private int count;
	
	public PeoplesDO() {
		super();
	}
	
	
	public PeoplesDO(List<Film> films, int count) {
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
