package com.example.REST_Pracice.service.impl;

import com.example.REST_Pracice.entity.Course;
import com.example.REST_Pracice.entity.dto.CourseDTO;
import com.example.REST_Pracice.repository.CourseRepository;
import com.example.REST_Pracice.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = courseRepository.save(modelMapper.map(courseDTO, Course.class));
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public void deleteCourse(Long courseId) {
        try {
            courseRepository.deleteById(courseId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
