package com.example.REST_Pracice.service;

import com.example.REST_Pracice.entity.dto.CourseDTO;

public interface CourseService {
    CourseDTO createCourse(CourseDTO courseDTO);

    void deleteCourse (Long CourseId);
}
