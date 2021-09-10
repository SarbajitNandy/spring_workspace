package com.infytel.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.PlanDTO;

@Entity
public class Customer {
	
	@Id
	@Column(name = "phone_no")
	private Long phoneNumber;
	private String name;
	private Integer age;
	private Character gender;
	private String address;
	private String currentPlan;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="plan_name")
	private Plan plan;
	
	public Customer() {}

	public Customer(Long phoneNumber, String name, Integer age, Character gender, String address,String currentPlan, Plan plan) {
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

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
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

	public static CustomerDTO prepareDTO(Customer custEntity)
	{
		Plan plan = new Plan(custEntity.getPlan().getPlanId(), custEntity.getPlan().getPlanName(), custEntity.getPlan().getLocalRate(), custEntity.getPlan().getNationalRate());
		PlanDTO planDTO = Plan.preparePlaDTO(plan);
		return new CustomerDTO(custEntity.getPhoneNumber(), custEntity.getName(), custEntity.getAge(), custEntity.getGender(), custEntity.getAddress(), custEntity.getCurrentPlan(), planDTO);
	}

	
}
