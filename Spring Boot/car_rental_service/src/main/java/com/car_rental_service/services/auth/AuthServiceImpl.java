package com.car_rental_service.services.auth;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.car_rental_service.dto.SignupRequest;
import com.car_rental_service.dto.UserDto;
import com.car_rental_service.entity.User;
import com.car_rental_service.enums.UserRole;
import com.car_rental_service.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

	private final UserRepository userRepository;
	
	@PostConstruct
	public void createAnAdminAccount() {
		Optional<User> adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
		if(adminAccount.isEmpty()) {
			User user = new User();
			user.setEmail("admin@test.com");
			user.setName("Admin");
			user.setUserRole(UserRole.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
			System.out.println("Admin account created successfully!!!");
			
		}else {
			System.out.println("Admin account already created!!!");
		}
	}

	@Override
	public UserDto createCustomer(SignupRequest signupRequest) {
		
		User user = new User();
		user.setName(signupRequest.getName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setUserRole(UserRole.CUSTOMER);
		User createdUser = userRepository.save(user);
		
		UserDto userDto = new UserDto();
		userDto.setId(createdUser.getId());
		return userDto;
	}

	@Override
	public boolean hasCustomerWithEmail(String email) {
		
		return userRepository.findFirstByEmail(email).isPresent();
	}

}














