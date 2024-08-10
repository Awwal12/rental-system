package com.example.rental_system.service;

import com.example.rental_system.entity.Bookings;
import com.example.rental_system.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;

    public List<Bookings> findAllBookings() {
        return bookingsRepository.findAll();
    }

    public Optional<Bookings> findBookingById(Long id) {
        return bookingsRepository.findById(id);
    }

    public Bookings saveBooking(Bookings booking) {
        return bookingsRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
    }
}
