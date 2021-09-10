package com.sarbajit.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarbajit.dto.StudentDto;
import com.sarbajit.entity.Student;
import com.sarbajit.repository.StudentRepository;

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
}
