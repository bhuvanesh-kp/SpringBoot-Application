package com.bhuvanesh.Order.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryServiceClient {
    @Value("${inventory.service.url}")
    private String url;

    public ResponseEntity<Void> updateInventory(final Long eventId, final Long capacity){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url + "/event/" + eventId + "/capacity/" + capacity, null);
        return ResponseEntity.ok().build();
    }
}
