package com.itcuties.registration.service.impl;

import com.itcuties.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Registration Business Object implementation. 
 * @author itcuties
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	public void registerUser(String firstname, String lastname, String email) {
		// Output some info
		LOG.info("registerUser: Registering user " + firstname + " " + lastname + ", with email " + email);
		
		// TODO: Contact your database here
		// ...
	}
	
}
