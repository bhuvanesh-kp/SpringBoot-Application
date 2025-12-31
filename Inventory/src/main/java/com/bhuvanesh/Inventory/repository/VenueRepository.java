package com.bhuvanesh.Inventory.repository;

import com.bhuvanesh.Inventory.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}
