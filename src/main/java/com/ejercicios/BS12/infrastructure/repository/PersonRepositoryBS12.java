package com.ejercicios.BS12.infrastructure.repository;

import com.ejercicios.BS12.domain.entities.PersonBS12;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepositoryBS12 extends JpaRepository<PersonBS12, Integer> {

  Optional<PersonBS12> findByUsuario(String usuario);

}
