package com.ejercicios.SA2.infrastructure.repository;

import com.ejercicios.SA2.domain.entities.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilesRepository extends JpaRepository<FilesEntity, Integer> {

    Optional<FilesEntity> findByName(String name);
}
