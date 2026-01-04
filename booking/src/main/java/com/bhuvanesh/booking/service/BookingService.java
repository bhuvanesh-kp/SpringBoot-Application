package com.bhuvanesh.booking.service;

import com.bhuvanesh.booking.client.InventoryServiceClient;
import com.bhuvanesh.booking.entity.Customer;
import com.bhuvanesh.booking.event.BookingEvent;
import com.bhuvanesh.booking.repository.CustomerRepository;
import com.bhuvanesh.booking.request.BookingRequest;
import com.bhuvanesh.booking.response.BookingResponse;
import com.bhuvanesh.booking.response.InventoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.math.BigDecimal;

@Slf4j
@Service
public class BookingService {

    private final CustomerRepository customerRepository;
    private final InventoryServiceClient inventoryServiceClient;
    private final KafkaTemplate<String, BookingEvent> kafkaTemplate;

    @Autowired
    BookingService(CustomerRepository customerRepository, InventoryServiceClient inventoryServiceClient, KafkaTemplate<String, BookingEvent> kafkaTemplate){
        this.customerRepository = customerRepository;
        this.inventoryServiceClient = inventoryServiceClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public BookingResponse createRequest(BookingRequest request){
        // check if the user exists
        final Customer customer = customerRepository.findById(request.getUserId()).orElse(null);
        if (customer == null) throw new RuntimeException("User not found");

        // check if there is enough inventory
        InventoryResponse inventoryResponse = inventoryServiceClient.getInventory(request.getEventId());
        log.info("Inventory Service Response {}" , inventoryResponse);

        if (inventoryResponse.getCapacity() < request.getTicketCount()){
            throw new RuntimeException("Not enough interview");
        }
        // get event and venue information
        // create booking
        final BookingEvent bookingEvent = createBookingEvent(request, customer, inventoryResponse);

        // send booking to order service via Kafka
        kafkaTemplate.send("bookingEvent", bookingEvent);
        log.info("booking message send in Kafka {}", bookingEvent);
        log.info("messages sent in kafka stream");

        return BookingResponse.builder()
                .userId(bookingEvent.getUserId())
                .eventId(bookingEvent.getEventId())
                .ticketCount(bookingEvent.getTicketCount())
                .ticketPrice(bookingEvent.getTicketPrice())
                .build();
    }

    private BookingEvent createBookingEvent(BookingRequest request, Customer customer, InventoryResponse inventoryResponse){
        return BookingEvent.builder()
                .eventId(request.getEventId())
                .userId(customer.getId())
                .ticketCount(request.getTicketCount())
                .ticketPrice(inventoryResponse.getTicketPrice().multiply(BigDecimal.valueOf(request.getTicketCount())))
                .build();
    }
}
