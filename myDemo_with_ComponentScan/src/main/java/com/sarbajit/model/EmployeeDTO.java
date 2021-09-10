package com.sarbajit.model;

import org.springframework.stereotype.Component;

public class EmployeeDTO {
	public static int COUNT_ID;
	public String name,dept;
	public int id;
	
	static {
		COUNT_ID = 100;
	}
	
	public EmployeeDTO(String name, String dept) {
		this.name=name; this.dept=dept;
		this.id = COUNT_ID++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", dept=" + dept + ", id=" + id + "]";
	}
	
	
	
	
}
