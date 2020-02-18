package com.sapient.assessment.films.dto;

import java.util.ArrayList;
import java.util.List;

public class FilmsDTO {
		
	private String name;
	private List<String> films;
	private int count;
	
	public FilmsDTO(FilmsDTOBuilder vehiclesDTOBuilder) {
		this.name=vehiclesDTOBuilder.name;
		this.films=vehiclesDTOBuilder.films;
		this.count=vehiclesDTOBuilder.count;
	}
	
	

	public String getName() {
		return name;
	}



	public List<String> getFilms() {
		if(films==null)
		{
			films = new ArrayList<>();
		}
		return films;
	}



	public int getCount() {
		return count;
	}


	public static class FilmsDTOBuilder{
		private String name;
		private List<String> films;
		private int count;
		
		public FilmsDTOBuilder()
		{
			
		}
		
		public FilmsDTOBuilder name(String name) {
			this.name = name;
			return this;
		}
		public FilmsDTOBuilder films(String films) {
			this.films= new ArrayList<>();
			this.films.add(films);
			return this;
		}
		public FilmsDTOBuilder count(int count) {
			this.count= count;
			return this;
		}
		
		public FilmsDTO build()
		{
			return new FilmsDTO(this);
		}
	}



	public static FilmsDTOBuilder newBuilder() {
		return new FilmsDTOBuilder();
	}

}
