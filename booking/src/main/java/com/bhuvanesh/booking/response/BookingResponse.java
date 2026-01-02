package com.bhuvanesh.booking.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    Long bookingId;
    Long userId;
    Long eventId;
    Long ticketCount;
    String ticketPrice;
}
