package com.car_rental_service.services.customer;

import java.util.List;

import com.car_rental_service.dto.BookACarDto;
import com.car_rental_service.dto.CarDto;
import com.car_rental_service.dto.CarDtoListDto;
import com.car_rental_service.dto.SearchCarDto;

public interface CustomerService {

	List<CarDto> getAllCars();
	
	boolean bookACar(BookACarDto bookACarDto);
	
	CarDto getCarById(Long id);
	
	List<BookACarDto> getBookingsByUserId(Long userId);
	
	CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
