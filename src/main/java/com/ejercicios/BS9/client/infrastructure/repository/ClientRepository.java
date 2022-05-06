package com.ejercicios.BS9.client.infrastructure.repository;

import com.ejercicios.BS9.client.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
