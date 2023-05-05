package com.example.REST_Pracice.repository;

import com.example.REST_Pracice.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
