package com.ejercicios.BS9.infrastructure.repository;

import com.ejercicios.BS9.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
