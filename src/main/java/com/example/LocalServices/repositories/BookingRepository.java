package com.example.LocalServices.repositories;

import com.example.LocalServices.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserFirstNameAndUserLastNameIgnoreCase(String firstName, String lastName);

    List<Booking> findByDateOfBooking(LocalDate dateOfBooking);

}
