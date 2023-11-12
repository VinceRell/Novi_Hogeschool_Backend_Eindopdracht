package com.NoviBackend.Autogarage.repositories;

import com.NoviBackend.Autogarage.models.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}
