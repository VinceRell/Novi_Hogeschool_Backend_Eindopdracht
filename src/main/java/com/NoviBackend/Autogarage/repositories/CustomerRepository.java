package com.NoviBackend.Autogarage.repositories;

import com.NoviBackend.Autogarage.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
