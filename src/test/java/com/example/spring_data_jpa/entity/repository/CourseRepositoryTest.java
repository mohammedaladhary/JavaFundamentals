package com.example.spring_data_jpa.entity.repository;

import com.example.spring_data_jpa.entity.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private Course course1;

    @BeforeEach
    void setUp() {
        course1 = new Course("CS105", "Data Structures and Algorithms");
        Course course2 = new Course("CS103", "Web Applications");
        courseRepository.save(course1);
        courseRepository.save(course2);
    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteById("CS105");
    }

    @Test
    public void testJPA(){
        Optional<Course> courseFromDb = courseRepository.findById("CS105");
        assertTrue(courseFromDb.isPresent());
        assertEquals(course1, courseFromDb.get());
    }

    @Test
    public void FindByCourseName(){
        Course courseFromDb = courseRepository.findByCourseName("Data Structures and Algorithms");
        assertEquals(course1.getCourseName(), "Data Structures and Algorithms");
    }

    @Test
    public void FindByCourseCode(){
        Course courseFromDb = courseRepository.findByCourseCode("CS105");
        assertEquals(course1.getCourseCode(), "CS105");
    }
}