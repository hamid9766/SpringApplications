package com.springmvc.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
