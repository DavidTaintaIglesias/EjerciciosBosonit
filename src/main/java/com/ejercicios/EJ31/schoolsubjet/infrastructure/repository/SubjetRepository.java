package com.ejercicios.EJ31.schoolsubjet.infrastructure.repository;

import com.ejercicios.EJ31.schoolsubjet.domain.entities.SchoolSubjetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjetRepository extends JpaRepository<SchoolSubjetEntity, Integer> {
}
