package com.example.REST_Pracice.web;

import com.example.REST_Pracice.entity.Student;
import com.example.REST_Pracice.entity.dto.CourseDTO;
import com.example.REST_Pracice.entity.dto.StudentDTO;
import com.example.REST_Pracice.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @PostMapping("/{studentId}/add/{courseId}")
    public Student addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.addCourseToStudent(studentId, courseId);
    }

    @GetMapping("/{studentId}")
    public List<CourseDTO> findAllCoursesForStudent(@PathVariable Long studentId) {
        return studentService.findAllCoursesForStudent(studentId);
    }

    @DeleteMapping("/{studentId}/delete/{courseId}")
    public void deleteStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.deleteStudentFromCourse(studentId, courseId);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
