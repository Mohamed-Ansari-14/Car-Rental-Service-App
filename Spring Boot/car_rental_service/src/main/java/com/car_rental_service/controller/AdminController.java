package com.car_rental_service.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_rental_service.dto.BookACarDto;
import com.car_rental_service.dto.CarDto;
import com.car_rental_service.dto.SearchCarDto;
import com.car_rental_service.services.admin.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

	private final AdminService adminService;

	@PostMapping("/car")
	public ResponseEntity<?> postCar(@ModelAttribute CarDto carDto) throws IOException{
		boolean success = adminService.postCar(carDto);

		if(success)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("/cars")
	public ResponseEntity<?> getAllCars(){
		return ResponseEntity.ok(adminService.getAllCars());
	}

	@DeleteMapping("/car/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable Long id){
		adminService.deleteCar(id);
		return ResponseEntity.ok(null);
	}

	@GetMapping("/car/{id}")
	public ResponseEntity<CarDto> getCarById(@PathVariable Long id){
		CarDto carDto = adminService.getCarById(id);
		return ResponseEntity.ok(carDto);
	}
	
	@PutMapping("/car/{carId}")
	public ResponseEntity<Void> updateCar(@PathVariable Long carId, @ModelAttribute CarDto carDto) throws IOException{
		try {
			boolean success = adminService.updateCar(carId, carDto);
			if(success)
				return ResponseEntity.status(HttpStatus.OK).build();
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/car/bookings")
	public ResponseEntity<List<BookACarDto>> getBookings(){
		return ResponseEntity.ok(adminService.getBookings());
	}
	
	@GetMapping("/car/booking/{bookingId}/{status}")
	public ResponseEntity<?> changeBookingStatus(@PathVariable Long bookingId,@PathVariable String status){
		boolean success = adminService.changeBookingStatus(bookingId, status);
		if(success)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/car/search")
	public ResponseEntity<?> searchCar(@RequestBody SearchCarDto searchCarDto){
		return ResponseEntity.ok(adminService.searchCar(searchCarDto));
	}
}













