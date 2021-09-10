package com.infytel.dto;


import com.infytel.entity.Customer;
import com.infytel.entity.Plan;


public class CustomerDTO {
	
	
	private Long phoneNumber;
	private String name;
	private Integer age;
	private Character gender;
	private String address;
	private String currentPlan;
	
	private PlanDTO plan;
	
	public CustomerDTO() {}

	public CustomerDTO(Long phoneNumber, String name, Integer age, Character gender, String address,String currentPlan, PlanDTO plan) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.currentPlan=currentPlan;
		this.plan = plan;
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

	public PlanDTO getPlan() {
		return plan;
	}

	public void setPlan(PlanDTO plan) {
		this.plan = plan;
	}
	
	

	public String getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(String currentPlan) {
		this.currentPlan = currentPlan;
	}

	@Override
	public String toString() {
		return "Customer [phoneNumber=" + phoneNumber + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", currentPlan=" + currentPlan + ", plan=" + plan + "]";
	}

	public static Customer prepareEntity(CustomerDTO custDTO)
	{
		Plan plan = new Plan(custDTO.getPlan().getPlanId(), custDTO.getPlan().getPlanName(), custDTO.getPlan().getLocalRate(), custDTO.getPlan().getNationalRate());
		return new Customer(custDTO.getPhoneNumber(),custDTO.getName(), custDTO.getAge(), custDTO.getGender(), custDTO.getAddress(), custDTO.getCurrentPlan(), plan);
		
	}

	
}
