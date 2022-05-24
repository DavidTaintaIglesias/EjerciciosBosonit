package com.ejercicios.EJS31.infrastructure.repository;

import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryEJS31 extends JpaRepository<StudentEJS31, Integer> {
}
