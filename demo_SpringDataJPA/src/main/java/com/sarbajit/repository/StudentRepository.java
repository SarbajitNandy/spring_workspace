package com.sarbajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarbajit.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
