package com.bhuvanesh.Inventory.service;

import com.bhuvanesh.Inventory.entity.Event;
import com.bhuvanesh.Inventory.entity.Venue;
import com.bhuvanesh.Inventory.repository.EventRepository;
import com.bhuvanesh.Inventory.repository.VenueRepository;
import com.bhuvanesh.Inventory.response.EventInventoryResponse;
import com.bhuvanesh.Inventory.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    private final EventRepository eventRepositoty;
    private final VenueRepository venueRepository;

    @Autowired
    public InventoryService(final EventRepository eventRepository, final VenueRepository venueRepository){
        this.eventRepositoty = eventRepository;
        this.venueRepository = venueRepository;
    }

    public List<EventInventoryResponse> getAllEvents() {
        List<Event> events = eventRepositoty.findAll();

        return events.stream().map(event -> EventInventoryResponse.builder()
                .event(event.getName())
                .capacity(event.getLeft_capacity())
                .venue(event.getVenue())
                .ticketPrice(event.getTicketPrice())
                .eventId(event.getId())
                .build()).collect(Collectors.toList());
    }

    public VenueInventoryResponse getVenueInformation(Long id) {
        Venue venue = venueRepository.findById(id).orElse(null);

        return VenueInventoryResponse.builder()
                .venueId(venue.getId())
                .name(venue.getName())
                .total_capacity(venue.getTotal_capacity())
                .build();
    }

    public EventInventoryResponse getEvent(final Long Id){
        Event event = eventRepositoty.findById(Id).orElse(null);

        return EventInventoryResponse.builder()
                .event(event.getName())
                .capacity(event.getLeft_capacity())
                .venue(event.getVenue())
                .ticketPrice(event.getTicketPrice())
                .eventId(event.getId())
                .build();
    }
}
