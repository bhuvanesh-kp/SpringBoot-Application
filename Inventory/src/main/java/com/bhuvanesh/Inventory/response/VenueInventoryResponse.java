package com.bhuvanesh.Inventory.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VenueInventoryResponse {
    Long venueId;
    String name;
    Long total_capacity;
}
