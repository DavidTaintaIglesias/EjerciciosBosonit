package com.ejercicios.EJ31.student.infrastructure.repository;

import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
