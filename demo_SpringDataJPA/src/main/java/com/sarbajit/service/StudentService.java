package com.sarbajit.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sarbajit.dto.StudentDto;
import com.sarbajit.entity.Student;
import com.sarbajit.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	public int insert(StudentDto stu) {
		Student s = StudentDto.createStudentEntity(stu);
		studentRepo.save(s);
		return s.getId();
	}
	
	public StudentDto findById(int studentId) throws NoSuchElementException{
		Optional<Student> op = studentRepo.findById(studentId);
		try {
			Student s = op.get();
			StudentDto st = Student.createStudentDto(s);
			return st;
		} catch (NoSuchElementException e) {
			System.out.println(studentId + " doesn't exists");
			throw e;
		}
	}
	
	public int delete(int studentId) throws NoSuchElementException{
		
		try {
			findById(studentId);
			studentRepo.deleteById(studentId);
			return studentId;
		} catch(NoSuchElementException e) {
			System.out.println(studentId + " doesn't exists");
			throw e;
		}	
	}
	
	public List<StudentDto> findAll() throws NoSuchElementException{
		
		List<Student> sAll=  studentRepo.findAll();	
		List<StudentDto> st = new ArrayList<>();
		
		for(Student s : sAll ) {
			st.add(Student.createStudentDto(s));
		}
			
		return st;
	}
	
	public List<StudentDto> findAll(Pageable page) {
		Iterable<Student> it= studentRepo.findAll(page);
		List<StudentDto> sAll = new ArrayList<>();
		
		for(Student s : it) {
			sAll.add(Student.createStudentDto(s));
		}
		
		return sAll;
	}
	
	public List<StudentDto> findAll(Sort sort) {
		Iterable<Student> it= studentRepo.findAll(sort);
		List<StudentDto> sAll = new ArrayList<>();
		
		for(Student s : it) {
			sAll.add(Student.createStudentDto(s));
		}
		
		return sAll;
	}
	
	public StudentDto updateById(StudentDto std) throws NoSuchElementException{
		Student s = StudentDto.createStudentEntity(std);
		try {
			findById(s.getId());
			studentRepo.save(s);
			return std;
		} catch (NoSuchElementException e) {
			System.out.println(s.getId() + " id not found");
			throw e;
		}
	}
	
	public List<StudentDto> findByName(String name) {
		List<Student> st = studentRepo.findBySname(name);
		List<StudentDto> sAll = new ArrayList<>();
		for(Student s : st) {
			sAll.add(Student.createStudentDto(s));
		}
		
		return sAll;
	}
	
	public List<StudentDto> findByDept(String dept) {
		List<Student> st = studentRepo.findByDept(dept);
		List<StudentDto> sAll = new ArrayList<>();
		for(Student s : st) {
			sAll.add(Student.createStudentDto(s));
		}
		
		return sAll;
	}
	
	public List<StudentDto> findBySnameAndDept(String name,String dept) {
		List<Student> st = studentRepo.findBySnameAndDept(name,dept);
		List<StudentDto> sAll = new ArrayList<>();
		for(Student s : st) {
			sAll.add(Student.createStudentDto(s));
		}
		
		return sAll;
	}

}
