package com.example.spring_data_jpa.entity.repository;

import com.example.spring_data_jpa.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
}


