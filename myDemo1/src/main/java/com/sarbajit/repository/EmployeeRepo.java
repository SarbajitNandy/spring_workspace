package com.sarbajit.repository;

import java.util.ArrayList;
import java.util.List;

import com.sarbajit.model.EmployeeDTO;

public class EmployeeRepo {
	public List<EmployeeDTO> empList;
	
	public EmployeeRepo () {
		empList = new ArrayList<EmployeeDTO>();
	}
	
	public void insert(EmployeeDTO emp) {
		empList.add(emp);
		System.out.println("Employee with id " + emp.getId() + " inserted.");
	}
	
	public void remove(EmployeeDTO emp) {
		int removeId = emp.getId();
		int listIndex = -1;
		for (int i=0; i<empList.size(); i++) {
			EmployeeDTO empDTO = empList.get(i);
			if (empDTO.getId()==removeId) {listIndex=i;}
		}
		if (listIndex!=-1) { 
			empList.remove(listIndex);
			System.out.println("Employee with id " + emp.getId() + " remove.");
		} else {
			System.out.println("Employee with id " + emp.getId() + " doesn't exists.");
		}
	}

	@Override
	public String toString() {
		return "EmployeeRepo [empList=" + empList + "]";
	}
	
}
