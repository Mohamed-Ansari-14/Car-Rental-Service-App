package com.car_rental_service.services.customer;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.car_rental_service.dto.BookACarDto;
import com.car_rental_service.dto.CarDto;
import com.car_rental_service.entity.BookACar;
import com.car_rental_service.entity.Car;
import com.car_rental_service.entity.User;
import com.car_rental_service.enums.BookCarStatus;
import com.car_rental_service.repository.BookACarRepository;
import com.car_rental_service.repository.CarRepository;
import com.car_rental_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CarRepository carRepository;
	
	private final UserRepository userRepository;
	
	private final BookACarRepository bookACarRepository;

	@Override
	public List<CarDto> getAllCars() {
		return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
	}

	@Override
	public boolean bookACar(BookACarDto bookACarDto) {
		Optional<Car> optionalCar = carRepository.findById(bookACarDto.getId());
		Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());
		if(optionalCar.isPresent() && optionalUser.isPresent()) {
			Car existingCar = optionalCar.get();
			BookACar bookACar = new BookACar();
			bookACar.setUser(optionalUser.get());
			bookACar.setCar(existingCar);
			bookACar.setBookCarStatus(BookCarStatus.PENDING);
			long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
			long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds);
			bookACar.setDays(days);
			bookACar.setPrice(existingCar.getPrice() * days);
			bookACarRepository.save(bookACar);
			return true;
		}
		return false;
	}
}


















