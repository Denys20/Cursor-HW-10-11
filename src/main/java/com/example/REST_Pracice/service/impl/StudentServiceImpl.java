package com.example.REST_Pracice.service.impl;

import com.example.REST_Pracice.entity.*;
import com.example.REST_Pracice.entity.dto.*;
import com.example.REST_Pracice.exeption.NotFoundExeption;
import com.example.REST_Pracice.repository.*;
import com.example.REST_Pracice.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = studentRepository.save(modelMapper.map(studentDTO, Student.class));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public Student addCourseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundExeption::new);
        List<Course> courses = student.getCourses();
        courses.add(course);
        student.setCourses(courses);
        return studentRepository.save(student);
    }

    @Override
    public List<CourseDTO> findAllCoursesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        return student.getCourses().stream().map(course -> modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NotFoundExeption::new);
        Course course = courseRepository.findById(courseId).orElseThrow(NotFoundExeption::new);
        List<Course> courses = student.getCourses();
        courses.remove(course);
        student.setCourses(courses);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        try {
            studentRepository.deleteById(studentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
