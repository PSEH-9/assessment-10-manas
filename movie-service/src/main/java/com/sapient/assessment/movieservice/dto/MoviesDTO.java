package com.sapient.assessment.movieservice.dto;

import java.util.List;

public class MoviesDTO {
	
	private String type="Planets";
	private String name;
	private List<String> films;
	private int count;
	
	public MoviesDTO(MoviesDTOBuilder moviesDTOBuilder) {
		this.name=moviesDTOBuilder.name;
		this.films=moviesDTOBuilder.films;
		this.count=moviesDTOBuilder.count;
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

	

	public String getType() {
		return type;
	}



	public static class MoviesDTOBuilder{
		private String name;
		private List<String> films;
		private int count;
		
		public MoviesDTOBuilder()
		{
			
		}
		
		public MoviesDTOBuilder name(String name) {
			this.name = name;
			return this;
		}
		public MoviesDTOBuilder films(List<String> films) {
			this.films= films;
			return this;
		}
		public MoviesDTOBuilder count(int count) {
			this.count= count;
			return this;
		}
		
		public MoviesDTO build()
		{
			return new MoviesDTO(this);
		}
	}



	public static MoviesDTOBuilder newBuilder() {
		return new MoviesDTOBuilder();
	}

}
