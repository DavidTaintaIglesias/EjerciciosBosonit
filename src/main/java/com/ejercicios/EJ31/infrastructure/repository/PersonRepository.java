package com.ejercicios.EJ31.infrastructure.repository;

import com.ejercicios.EJ31.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

  Optional<Person> findByUser(String user);

}
