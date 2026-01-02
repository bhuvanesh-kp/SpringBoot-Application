package com.bhuvanesh.Inventory.controller;

import com.bhuvanesh.Inventory.response.EventInventoryResponse;
import com.bhuvanesh.Inventory.response.VenueInventoryResponse;
import com.bhuvanesh.Inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllService(){
        return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryVenueById(@PathVariable("venueId") Long id){
        return inventoryService.getVenueInformation(id);
    }

    @GetMapping("/inventory/event/{eventId}")
    public @ResponseBody EventInventoryResponse inventoryForEvent(@PathVariable("eventId") Long id){
        return inventoryService.getEvent(id);
    }
}
