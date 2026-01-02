package com.bhuvanesh.booking.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingRequest {
    Long userId;
    Long eventId;
    Long ticketCount;
}
