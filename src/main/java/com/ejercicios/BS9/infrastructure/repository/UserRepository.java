package com.ejercicios.BS9.infrastructure.repository;

import com.ejercicios.BS9.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
