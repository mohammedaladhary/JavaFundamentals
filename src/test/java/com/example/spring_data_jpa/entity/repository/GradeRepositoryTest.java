package com.example.spring_data_jpa.entity.repository;

import com.example.spring_data_jpa.entity.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepo;

    private Grade grade1;
    private Grade grade2;

    @BeforeEach
    public void setUp() {
        grade1 = new Grade("Michael Alcocer", "CS103-A", 65);
        gradeRepo.save(grade1);

        grade2 = new Grade("Maya Charlotte", "CS101-A", 98);
        gradeRepo.save(grade2);
    }

    @AfterEach
    public void tearDown() {
        gradeRepo.deleteAll();
    }

    @Test
    public void testFindAll() {
        List<Grade> gradeList = gradeRepo.findAll();
        assertEquals(2, gradeList.size());
    }

    @Test
    public void testUpdate() {
        grade1.setScore(75);
        gradeRepo.save(grade1);

        Grade fromRepo = gradeRepo.findById(grade1.getId()).get();
        assertEquals(grade1, fromRepo);
    }

    @Test
    public void testDelete() {
        gradeRepo.delete(grade1);
        List<Grade> gradeList = gradeRepo.findAll();
        assertEquals(1, gradeList.size());
    }
}