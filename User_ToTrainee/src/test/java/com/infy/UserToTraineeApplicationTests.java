package com.infy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.AddressDTO;
import com.infy.dto.UserDTO;
import com.infy.exception.UsersException;
import com.infy.repository.UserRepository;
import com.infy.service.UserService;
import com.infy.service.UserServiceImpl;


@SpringBootTest
class UserToTraineeApplicationTests {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService=new UserServiceImpl();
	
	@Test
	void addUserValidTest() throws UsersException {
		UserDTO user = new UserDTO();
		user.setUserId(1008);
		user.setUserName("James");
		user.setPassword("James@123");
		user.setEmail("james@yahoo.in");
		user.setMobileNumber("3335651233");
		
		AddressDTO address = new AddressDTO();
		address.setDoorNumber("108A");
		address.setStreet("Fifth Main Street");
		address.setCity("Phoenix");
		address.setState("Arizona");
		address.setZipCode(85003);
		
		user.setAddress(address);
		
		Mockito.when(userService.addUser(user)).thenReturn(1008);	
	}

	@Test
	void addUserInvalidUserNameTest() throws UsersException {
		UserDTO user = new UserDTO();
		user.setUserId(1008);
		user.setUserName("James8");
		user.setPassword("James@123");
		user.setEmail("james@yahoo.in");
		user.setMobileNumber("3335651233");
		
		AddressDTO address = new AddressDTO();
		address.setDoorNumber("108A");
		address.setStreet("Fifth Main Street");
		address.setCity("Phoenix");
		address.setState("Arizona");
		address.setZipCode(85003);
		
		user.setAddress(address);
		
//		Mockito.when(userService.addUser(user)).thenReturn(1008);	
		UsersException exception = Assertions.assertThrows(UsersException.class, ()-> userService.addUser(user));
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_USERNAME");
	}

	@Test
	void addUserInvalidPasswordTest() throws UsersException {
		UserDTO user = new UserDTO();
		user.setUserId(1008);
		user.setUserName("James");
		user.setPassword("James@1");
		user.setEmail("james@yahoo.in");
		user.setMobileNumber("3335651233");
		
		AddressDTO address = new AddressDTO();
		address.setDoorNumber("108A");
		address.setStreet("Fifth Main Street");
		address.setCity("Phoenix");
		address.setState("Arizona");
		address.setZipCode(85003);
		
		user.setAddress(address);
		
//		Mockito.when(userService.addUser(user)).thenReturn(1008);	
		UsersException exception = Assertions.assertThrows(UsersException.class, ()-> userService.addUser(user));
		
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_PASSWORD");
	}

	@Test
	void addUserInvalidEmailTest() throws UsersException {
		UserDTO user = new UserDTO();
		user.setUserId(1008);
		user.setUserName("James");
		user.setPassword("James@123");
		user.setEmail("james@yahoo");
		user.setMobileNumber("3335651233");
		
		AddressDTO address = new AddressDTO();
		address.setDoorNumber("108A");
		address.setStreet("Fifth Main Street");
		address.setCity("Phoenix");
		address.setState("Arizona");
		address.setZipCode(85003);
		
		user.setAddress(address);
		
//		Mockito.when(userService.addUser(user)).thenReturn(1008);
		UsersException exception = Assertions.assertThrows(UsersException.class, ()-> userService.addUser(user));
		
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_EMAIL");
	}

	@Test
	void addUserInvalidMobileNumberTest() throws UsersException {
		UserDTO user = new UserDTO();
		user.setUserId(1008);
		user.setUserName("James");
		user.setPassword("James@123");
		user.setEmail("james@yahoo.in");
		user.setMobileNumber("333565123");
		
		AddressDTO address = new AddressDTO();
		address.setDoorNumber("108A");
		address.setStreet("Fifth Main Street");
		address.setCity("Phoenix");
		address.setState("Arizona");
		address.setZipCode(85003);
		
		user.setAddress(address);
		
//		Mockito.when(userService.addUser(user)).thenReturn(1008);	
		UsersException exception = Assertions.assertThrows(UsersException.class, ()-> userService.addUser(user));
		
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_MOBILENO");
	}

	@Test
	void addUserInvalidAddressTest() throws UsersException {
		UserDTO user = new UserDTO();
		user.setUserId(1008);
		user.setUserName("James");
		user.setPassword("James@123");
		user.setEmail("james@yahoo.in");
		user.setMobileNumber("3335651233");
		
		AddressDTO address = new AddressDTO();
		address.setDoorNumber("108A");
		address.setStreet("Fifth Main Street");
		address.setCity("Phoenix");
		address.setState("Arizona");
		address.setZipCode(850093);
		
		user.setAddress(address);
		
//		Mockito.when(userService.addUser(user)).thenReturn(1008);
		UsersException exception = Assertions.assertThrows(UsersException.class, ()-> userService.addUser(user));
		
		Assertions.assertEquals(exception.getMessage(), "Validator.INVALID_ADDRESS");
	}

}