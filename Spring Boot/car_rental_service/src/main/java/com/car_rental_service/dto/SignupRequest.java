package com.car_rental_service.dto;

import lombok.Data;

@Data
public class SignupRequest {

	private String email;
	
	private String name;
	
	private String password;
	
}
