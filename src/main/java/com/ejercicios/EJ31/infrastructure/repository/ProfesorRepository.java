package com.ejercicios.EJ31.infrastructure.repository;

import com.ejercicios.EJ31.domain.entities.ProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Integer> {
}
