package com.sapient.assessment.films.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Plants not found")
public class FilmsNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FilmsNotFoundException(String msg)
	{
		super(msg);
	}

}
