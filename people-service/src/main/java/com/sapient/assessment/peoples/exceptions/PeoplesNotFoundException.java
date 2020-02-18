package com.sapient.assessment.peoples.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Plants not found")
public class PeoplesNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PeoplesNotFoundException(String msg)
	{
		super(msg);
	}

}
