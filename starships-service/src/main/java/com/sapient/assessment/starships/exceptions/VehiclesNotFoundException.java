package com.sapient.assessment.vehicles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Plants not found")
public class VehiclesNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VehiclesNotFoundException(String msg)
	{
		super(msg);
	}

}
