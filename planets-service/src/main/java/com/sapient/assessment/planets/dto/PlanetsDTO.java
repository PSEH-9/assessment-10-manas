package com.sapient.assessment.planets.dto;

import java.util.List;

public class PlanetsDTO {
	
	private String name;
	private List<String> films;
	private int count;
	
	public PlanetsDTO(PlanetsDTOBuilder planetsDTOBuilder) {
		this.name=planetsDTOBuilder.name;
		this.films=planetsDTOBuilder.films;
		this.count=planetsDTOBuilder.count;
	}
	
	

	public String getName() {
		return name;
	}



	public List<String> getFilms() {
		return films;
	}



	public int getCount() {
		return count;
	}

	
	public static class PlanetsDTOBuilder{
		private String name;
		private List<String> films;
		private int count;
		
		public PlanetsDTOBuilder()
		{
			
		}
		
		public PlanetsDTOBuilder name(String name) {
			this.name = name;
			return this;
		}
		public PlanetsDTOBuilder films(List<String> films) {
			this.films= films;
			return this;
		}
		public PlanetsDTOBuilder count(int count) {
			this.count= count;
			return this;
		}
		
		public PlanetsDTO build()
		{
			return new PlanetsDTO(this);
		}
	}



	public static PlanetsDTOBuilder newBuilder() {
		return new PlanetsDTOBuilder();
	}

}
