package com.sarbajit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbajit.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findBySname(String name);
	List<Student> findByDept(String dept);
	
	List<Student> findBySnameAndDept(String name,String dept);
	
	
}
