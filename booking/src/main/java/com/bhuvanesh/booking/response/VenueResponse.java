package com.bhuvanesh.booking.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VenueResponse {
    Long id;
    String name;
    Long total_capacity;
    String address;
}
