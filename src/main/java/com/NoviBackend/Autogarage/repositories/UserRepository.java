package com.NoviBackend.Autogarage.repositories;

import com.NoviBackend.Autogarage.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
