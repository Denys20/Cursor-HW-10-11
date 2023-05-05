package com.example.REST_Pracice.repository;

import com.example.REST_Pracice.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
