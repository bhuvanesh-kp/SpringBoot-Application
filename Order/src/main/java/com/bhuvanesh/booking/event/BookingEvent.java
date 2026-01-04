package com.bhuvanesh.booking.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

