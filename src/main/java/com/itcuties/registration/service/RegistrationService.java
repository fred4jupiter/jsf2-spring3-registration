package com.itcuties.registration.service;

/**
 * Registration Business Object interface.
 * @author itcuties
 *
 */
public interface RegistrationService {
	/**
	 * Register user method
	 * @param firstname
	 * @param lastname
	 * @param email
	 */
	void registerUser(String firstname, String lastname, String email);
}
