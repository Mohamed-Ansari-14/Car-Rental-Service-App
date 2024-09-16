package com.car_rental_service.services.customer;

import java.util.List;

import com.car_rental_service.dto.BookACarDto;
import com.car_rental_service.dto.CarDto;

public interface CustomerService {

	List<CarDto> getAllCars();
	
	boolean bookACar(BookACarDto bookACarDto);
}
