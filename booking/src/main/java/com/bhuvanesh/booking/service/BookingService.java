package com.bhuvanesh.booking.service;

import com.bhuvanesh.booking.client.InventoryServiceClient;
import com.bhuvanesh.booking.entity.Customer;
import com.bhuvanesh.booking.repository.CustomerRepository;
import com.bhuvanesh.booking.request.BookingRequest;
import com.bhuvanesh.booking.response.BookingResponse;
import com.bhuvanesh.booking.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final CustomerRepository customerRepository;
    private final InventoryServiceClient inventoryServiceClient;

    @Autowired
    BookingService(CustomerRepository customerRepository, InventoryServiceClient inventoryServiceClient){
        this.customerRepository = customerRepository;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    public BookingResponse createRequest(BookingRequest request){
        // check if the user exists
        final Customer customer = customerRepository.findById(request.getUserId()).orElse(null);
        if (customer == null) throw new RuntimeException("User not found");

        // check if there is enough inventory
        InventoryResponse inventoryResponse = inventoryServiceClient.getInventory(request.getEventId());
        System.out.printf("Inventory Service Response " + inventoryResponse);

        if (inventoryResponse.getCapacity() < request.getTicketCount()){
            throw new RuntimeException("Not enough interview");
        }
        // get event and venue information
        // create booking
        // send booking to order service via Kafka
        return BookingResponse.builder().build();
    }
}
