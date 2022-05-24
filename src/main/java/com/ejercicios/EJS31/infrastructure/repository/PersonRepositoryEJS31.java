package com.ejercicios.EJS31.infrastructure.repository;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepositoryEJS31 extends JpaRepository<PersonEJS31, Integer> {

    Optional<PersonEJS31> findByUser(String user);
}
