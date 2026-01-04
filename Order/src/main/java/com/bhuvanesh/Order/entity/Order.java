package com.bhuvanesh.Order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "total")
    BigDecimal totalPrice;

    @Column(name = "quantity")
    Long ticketCount;

    @Column(name = "placed_at")
    LocalDateTime placedAt;

    @Column(name = "customer_id")
    Long customerId;

    @Column(name = "event_id")
    Long eventId;
}
