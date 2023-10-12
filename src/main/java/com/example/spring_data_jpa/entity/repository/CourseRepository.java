package com.example.spring_data_jpa.entity.repository;

import com.example.spring_data_jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    Course findByCourseName(String courseCode);
    Course findByCourseCode(String courseCode);
}
