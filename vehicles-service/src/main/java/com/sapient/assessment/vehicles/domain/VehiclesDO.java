package com.sapient.assessment.vehicles.domain;

import java.util.List;

public class VehiclesDO {
	
	private List<Film> results;
	private int count;
	
	public VehiclesDO() {
		super();
	}
	
	
	public VehiclesDO(List<Film> films, int count) {
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
