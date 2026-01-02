package com.bhuvanesh.booking.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventoryResponse {
    Long eventId;
    String event;
    Long capacity;
    VenueResponse venue;
    BigDecimal ticketPrice;
}
