package com.bhuvanesh.Inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "event")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "total_capacity")
    Long total_capacity;

    @Column(name = "left_capacity")
    Long left_capacity;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @Column(name = "ticket_price")
    BigDecimal ticketPrice;
}
