package com.ejercicios.BS9.user.infrastructure.repository;

import com.ejercicios.BS9.user.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
