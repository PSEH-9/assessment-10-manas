package com.sapient.assessment.peoples.dto;

import java.util.List;

public class PeoplesDTO {
		
	private String name;
	private List<String> films;
	private int count;
	
	public PeoplesDTO(VehiclesDTOBuilder vehiclesDTOBuilder) {
		this.name=vehiclesDTOBuilder.name;
		this.films=vehiclesDTOBuilder.films;
		this.count=vehiclesDTOBuilder.count;
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


	public static class VehiclesDTOBuilder{
		private String name;
		private List<String> films;
		private int count;
		
		public VehiclesDTOBuilder()
		{
			
		}
		
		public VehiclesDTOBuilder name(String name) {
			this.name = name;
			return this;
		}
		public VehiclesDTOBuilder films(List<String> films) {
			this.films= films;
			return this;
		}
		public VehiclesDTOBuilder count(int count) {
			this.count= count;
			return this;
		}
		
		public PeoplesDTO build()
		{
			return new PeoplesDTO(this);
		}
	}



	public static VehiclesDTOBuilder newBuilder() {
		return new VehiclesDTOBuilder();
	}

}
