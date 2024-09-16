package com.car_rental_service.services.auth;

import com.car_rental_service.dto.SignupRequest;
import com.car_rental_service.dto.UserDto;

public interface AuthService {

	UserDto createCustomer(SignupRequest signupRequest);
	
	boolean hasCustomerWithEmail(String email);
}
