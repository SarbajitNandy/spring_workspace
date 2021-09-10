package com.infytel.dto;

import com.infytel.domain.Customer;

public class CustomerDTO {

	private Long phoneNumber;
	private String name;
	private Integer age;
	private Character gender;
	private String address;

	public CustomerDTO(Long phoneNumber, String name, Integer age, Character gender, String address) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [phoneNumber=" + phoneNumber + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + "]";
	}

	public static Customer prepareCustomerEntity(CustomerDTO customerDTO) {
		Customer customerEntity = new Customer();
		customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
		customerEntity.setName(customerDTO.getName());
		customerEntity.setGender(customerDTO.getGender());
		customerEntity.setAge(customerDTO.getAge());
		customerEntity.setAddress(customerDTO.getAddress());

		return customerEntity;

	}
}
