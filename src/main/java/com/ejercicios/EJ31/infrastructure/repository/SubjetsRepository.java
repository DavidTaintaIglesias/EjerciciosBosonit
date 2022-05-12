package com.ejercicios.EJ31.infrastructure.repository;

import com.ejercicios.EJ31.domain.entities.Subjet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjetsRepository extends JpaRepository<Subjet, Integer> {

}
