package com.bhuvanesh.Order.service;

import com.bhuvanesh.Order.client.InventoryServiceClient;
import com.bhuvanesh.Order.entity.Order;
import com.bhuvanesh.Order.repository.OrderRepository;
import com.bhuvanesh.booking.event.BookingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private InventoryServiceClient inventoryServiceClient;

    public OrderService(OrderRepository orderRepository, InventoryServiceClient inventoryServiceClient) {
        this.orderRepository = orderRepository;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "bookingEvent", groupId = "order-service")
    public void  orderEvent(BookingEvent bookingEvent){
        log.info("Received order event {}", bookingEvent);

        // create order object and save it
        Order order = createOrderEvent(bookingEvent);
        orderRepository.saveAndFlush(order);

        // update it in main DB
        inventoryServiceClient.updateInventory(order.getEventId(), order.getTicketCount());
    }

    private Order createOrderEvent(BookingEvent request){
        return Order.builder()
                .eventId(request.getEventId())
                .customerId(request.getUserId())
                .ticketCount(request.getTicketCount())
                .totalPrice(request.getTicketPrice())
                .build();
    }
}
