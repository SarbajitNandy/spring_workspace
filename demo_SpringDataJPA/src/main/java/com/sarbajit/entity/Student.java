package com.sarbajit.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import com.sarbajit.dto.StudentDto;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="sid")
	private int id;
	private String sname;
	private String dept;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", dept=" + dept + "]";
	}
	
	public static StudentDto createStudentDto(Student stu) {
		StudentDto s = new StudentDto();
		s.setDept(stu.getDept());
		s.setId(stu.getId());
		s.setSname(stu.getSname());
		return s;		
	}
}
