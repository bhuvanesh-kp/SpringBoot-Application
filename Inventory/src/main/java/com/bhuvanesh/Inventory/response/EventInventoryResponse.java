package com.bhuvanesh.Inventory.response;

import com.bhuvanesh.Inventory.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventInventoryResponse {
    Long eventId;
    String event;
    Long capacity;
    Venue venue;
    BigDecimal ticketPrice;
}
