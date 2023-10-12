package com.example.spring_data_jpa.entity.repository;

import com.example.spring_data_jpa.entity.Grade;
import com.example.spring_data_jpa.entity.Section;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SectionRepositoryTest {

    @Autowired
    private SectionRepository sectionRepo;

    @BeforeEach
    public void setUp() {
        Section section = new Section("SECTION_ID_1", "COURSE_CODE_1", (short) 101, "Instructor 1");
        sectionRepo.save(section);
    }

    @AfterEach
    public void tearDown() {
        // You can add cleanup logic here, for example, deleting test data.
        sectionRepo.deleteAll();
    }


    @Test
    public void testFindAll() {
        List<Section> gradeList = sectionRepo.findAll();
        assertEquals(1, gradeList.size());
    }
}