package com.sarbajit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sarbajit.dto.StudentDto;
import com.sarbajit.service.StudentService;

import java.util.List;

@SpringBootApplication
public class DemoSpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataJpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		StudentDto s = studentService.findById(2);
//		System.out.println(s);
//		
//		StudentDto st = new StudentDto();
//		st.setDept("ECE");
//		st.setId(5);
//		st.setSname("Priya");
//		
//		int sN= studentService.insert(st);
//		System.out.println(sN + " id inserted");
//		
//		StudentDto s2 = new StudentDto();
//		s2.setDept("IT");
//		s2.setId(1);
//		s2.setSname("");
//		
//		studentService.updateById(s2);
		
//		Pageable pg = PageRequest.of(0, 2);
		
		
		List<StudentDto> sAll = studentService.findAll(Sort.by(Sort.Direction.DESC, "sname"));
		
		System.out.println("All Students");
		for(StudentDto sI : sAll) {
			System.out.println(sI);
		}
		
	}

}











