package com.infytel.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {
	
	@Id
	private Long phoneNumber;
	private String name;
	private Integer age;
	private Character gender;
	private String address;
	
	
	public Customer() {}
	
	public Customer(Long phoneNumber, String name, Integer age, Character gender, String address) {
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
				+ ", address=" + address +"]";
	}
	
	
}

