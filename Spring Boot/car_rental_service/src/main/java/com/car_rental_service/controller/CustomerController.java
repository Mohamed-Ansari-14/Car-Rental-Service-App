package com.car_rental_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_rental_service.dto.BookACarDto;
import com.car_rental_service.dto.CarDto;
import com.car_rental_service.services.customer.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping("/cars")
	public ResponseEntity<List<CarDto>> getAllCars(){
		List<CarDto> carDtoList = customerService.getAllCars();
		return ResponseEntity.ok(carDtoList);
	}

	@PostMapping("/car/book")
	public ResponseEntity<Void> bookACar(@RequestBody BookACarDto bookACarDto){
		boolean success = customerService.bookACar(bookACarDto);
		if(success)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}













