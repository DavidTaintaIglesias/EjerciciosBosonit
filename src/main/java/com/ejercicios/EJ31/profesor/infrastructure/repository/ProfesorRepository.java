package com.ejercicios.EJ31.profesor.infrastructure.repository;

import com.ejercicios.EJ31.profesor.domain.entities.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Integer> {
}
