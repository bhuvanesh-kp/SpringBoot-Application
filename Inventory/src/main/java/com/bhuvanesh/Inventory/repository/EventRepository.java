package com.bhuvanesh.Inventory.repository;

import com.bhuvanesh.Inventory.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
