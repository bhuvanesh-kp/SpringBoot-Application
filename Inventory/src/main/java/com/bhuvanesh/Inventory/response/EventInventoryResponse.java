package com.bhuvanesh.Inventory.response;

import com.bhuvanesh.Inventory.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventInventoryResponse {
    String event;
    Long capacity;
    Venue venue;
}
