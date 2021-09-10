package com.sarbajit.dto;

import com.sarbajit.entity.Student;

public class StudentDto {
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
		return "StudentDto [id=" + id + ", sname=" + sname + ", dept=" + dept + "]";
	}
	
	public static Student createStudentEntity(StudentDto stu) {
		Student s = new Student();
		s.setDept(stu.getDept());
		s.setId(stu.getId());
		s.setSname(stu.getSname());
		return s;
	}
}
