package com.car_rental_service.dto;

import java.util.Date;

import com.car_rental_service.enums.BookCarStatus;

import lombok.Data;

@Data
public class BookACarDto {

	private Long id;

	private Date fromDate;

	private Date toDate;

	private Long days;

	private Long price;

	private BookCarStatus bookCarStatus;

	private Long CarId;
	
	private Long userId;
}
