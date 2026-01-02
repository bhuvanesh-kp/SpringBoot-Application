package com.bhuvanesh.booking.controller;

import com.bhuvanesh.booking.request.BookingRequest;
import com.bhuvanesh.booking.response.BookingResponse;
import com.bhuvanesh.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    BookingController(final BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping(path = "/booking", consumes = "application/json", produces = "application/json")
    public BookingResponse createBookingRequest(@RequestBody BookingRequest request){
        return bookingService.createRequest(request);
    }
}
