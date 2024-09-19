package com.car_rental_service.services.admin;

import java.io.IOException;
import java.util.List;

import com.car_rental_service.dto.BookACarDto;
import com.car_rental_service.dto.CarDto;
import com.car_rental_service.dto.CarDtoListDto;
import com.car_rental_service.dto.SearchCarDto;

public interface AdminService {

	boolean postCar(CarDto carDto) throws IOException;
	
	List<CarDto> getAllCars();
	
	void deleteCar(Long id);
	
	CarDto getCarById(Long id);
	
	boolean updateCar(Long carId, CarDto carDto) throws IOException;
	
	List<BookACarDto> getBookings();
	
	boolean changeBookingStatus(Long bookingId, String status);
	
	CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
