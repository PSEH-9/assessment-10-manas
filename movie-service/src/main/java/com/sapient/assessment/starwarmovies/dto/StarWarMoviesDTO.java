package com.sapient.assessment.starwarmovies.dto;

import java.util.List;

public class StarWarMoviesDTO {
	
	private String type="Planets";
	private String name;
	private List<String> films;
	private int count;
	
	public StarWarMoviesDTO(StarWarMoviesDTOBuilder moviesDTOBuilder) {
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



	public static class StarWarMoviesDTOBuilder{
		private String name;
		private List<String> films;
		private int count;
		private String type;
		
		public StarWarMoviesDTOBuilder()
		{
			
		}
		
		public StarWarMoviesDTOBuilder name(String name) 
		{
			this.name = name;
			return this;
		}
		public StarWarMoviesDTOBuilder films(List<String> films) 
		{
			this.films= films;
			return this;
		}
		public StarWarMoviesDTOBuilder count(int count) 
		{
			this.count= count;
			return this;
		}
		public StarWarMoviesDTOBuilder type(String type) 
		{
			this.type= type;
			return this;
		}
		public StarWarMoviesDTO build()
		{
			return new StarWarMoviesDTO(this);
		}
	}



	public static StarWarMoviesDTOBuilder newBuilder() {
		return new StarWarMoviesDTOBuilder();
	}

}
