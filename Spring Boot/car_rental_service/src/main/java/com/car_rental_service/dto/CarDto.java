package com.car_rental_service.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CarDto {

	private Long id;

	private String brand;

	private String color;

	private String name;

	private String type;

	private String transmission;

	private String description;

	private Long price;

	@DateTimeFormat(pattern = "yyyy")
	private Date year;

	private MultipartFile image;
	
	private byte[] returnedImage;
}






