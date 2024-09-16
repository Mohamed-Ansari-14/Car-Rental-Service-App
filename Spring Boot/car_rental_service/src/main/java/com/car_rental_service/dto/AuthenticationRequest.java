package com.car_rental_service.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

	private String email;
	
	private String password;
}
