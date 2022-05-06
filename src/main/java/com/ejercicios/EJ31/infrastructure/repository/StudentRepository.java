package com.ejercicios.EJ31.infrastructure.repository;

import com.ejercicios.EJ31.domain.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
