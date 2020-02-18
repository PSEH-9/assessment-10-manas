package com.sapient.assessment.peoples.service;

import com.sapient.assessment.peoples.domain.PeoplesDO;
import com.sapient.assessment.peoples.exceptions.PeoplesNotFoundException;


public interface PeoplesService {
	
	
	public PeoplesDO findByName(String name) throws PeoplesNotFoundException,Exception;
}
