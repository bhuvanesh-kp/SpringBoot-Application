package com.bhuvanesh.Inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "venue")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "total_capacity")
    Long total_capacity;

    @Column(name = "address")
    String address;
}
