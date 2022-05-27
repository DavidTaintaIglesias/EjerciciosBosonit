package com.ejercicios.SA2.infrastructure.repository;

import com.ejercicios.SA2.domain.entities.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Integer> {

    Files findByName(String name);
}
