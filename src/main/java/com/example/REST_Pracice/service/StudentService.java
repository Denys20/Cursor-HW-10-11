package com.example.REST_Pracice.service;

import com.example.REST_Pracice.entity.Student;
import com.example.REST_Pracice.entity.dto.CourseDTO;
import com.example.REST_Pracice.entity.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    Student addCourseToStudent(Long studentId, Long courseId);

    List<CourseDTO> findAllCoursesForStudent(Long studentId);

    void deleteStudentFromCourse(Long studentId, Long courseId);

    void deleteStudent(Long studentId);
}
