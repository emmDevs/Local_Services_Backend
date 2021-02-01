package com.example.LocalServices.controllers;

import com.example.LocalServices.models.Booking;
import com.example.LocalServices.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class BookingController {

    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
            AntPathMatcher matcher = new AntPathMatcher();
            matcher.setCaseSensitive(false);
            configurer.setPathMatcher(matcher);
        }
    }

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/bookings/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value="/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Long id){
        Booking bookingToUpdate = bookingRepository.findById(id).get();
        bookingToUpdate.setDate_booking_made(booking.getDate_booking_made());
        bookingToUpdate.setDate_of_booking(booking.getDate_of_booking());
        bookingToUpdate.setArrival_time(booking.getArrival_time());
        bookingToUpdate.setDeparture_time(booking.getDeparture_time());
        bookingToUpdate.setComments(booking.getComments());
        bookingRepository.save(bookingToUpdate);
        return new ResponseEntity<>(bookingToUpdate, HttpStatus.OK);
    }


}
