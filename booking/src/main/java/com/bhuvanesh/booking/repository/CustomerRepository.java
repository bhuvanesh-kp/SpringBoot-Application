package com.bhuvanesh.booking.repository;

import com.bhuvanesh.booking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
