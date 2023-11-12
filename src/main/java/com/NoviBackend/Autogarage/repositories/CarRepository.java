package com.NoviBackend.Autogarage.repositories;

import com.NoviBackend.Autogarage.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
