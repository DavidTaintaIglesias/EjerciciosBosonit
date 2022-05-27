package com.ejercicios.SA2.infrastructure.repository;

import com.ejercicios.SA2.domain.entities.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<FilesEntity, Integer> {

    FilesEntity findByName(String name);
}
