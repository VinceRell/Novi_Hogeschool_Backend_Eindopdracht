package com.NoviBackend.Autogarage.repositories;

import com.NoviBackend.Autogarage.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByUsername(String email);
}
