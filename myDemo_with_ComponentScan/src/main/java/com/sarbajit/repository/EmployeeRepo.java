package com.sarbajit.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sarbajit.model.EmployeeDTO;

@Repository
public class EmployeeRepo {
	public List<EmployeeDTO> empList;
	
	public EmployeeRepo () {
		empList = new ArrayList<EmployeeDTO>();
		System.out.println("Repo const called");
	}
	
	public int insert(EmployeeDTO emp) {
		empList.add(emp);
		return emp.getId();
	}
	
	public int remove(EmployeeDTO emp) {
		int removeId = emp.getId();
		int listIndex = -1;
		for (int i=0; i<empList.size(); i++) {
			EmployeeDTO empDTO = empList.get(i);
			if (empDTO.getId()==removeId) {listIndex=i;}
		}
		if (listIndex!=-1) { 
			empList.remove(listIndex);
			return emp.getId();
		} else {
			return -emp.getId();
		}
	}

	@Override
	public String toString() {
		return "EmployeeRepo [empList=" + empList + "]";
	}
	
}
