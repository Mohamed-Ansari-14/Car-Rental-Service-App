package com.car_rental_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car_rental_service.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
