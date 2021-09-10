package com.sarbajit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sarbajit.dto.StudentDto;
import com.sarbajit.service.StudentService;

@SpringBootApplication
public class DemoSpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataJpaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		StudentDto s = studentService.findById(2);
		System.out.println(s);
		
		StudentDto st = new StudentDto();
		st.setDept("ECE");
		st.setId(5);
		st.setSname("Priya");
		
		int sN= studentService.insert(st);
		System.out.println(sN + " id inserted");
	}

}
