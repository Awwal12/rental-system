package com.example.rental_system.controller;

import com.example.rental_system.entity.Bookings;
import com.example.rental_system.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping
    public List<Bookings> getAllBookings() {
        return bookingsService.findAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable Long id) {
        Optional<Bookings> booking = bookingsService.findBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bookings createBooking(@RequestBody Bookings booking) {
        return bookingsService.saveBooking(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingsService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
