package com.bhuvanesh.booking.event;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEvent {
    Long userId;
    Long eventId;
    Long ticketCount;
    BigDecimal ticketPrice;
}
