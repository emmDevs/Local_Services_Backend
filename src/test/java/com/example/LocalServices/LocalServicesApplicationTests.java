package com.example.LocalServices;

import com.example.LocalServices.models.Booking;
import com.example.LocalServices.models.User;
import com.example.LocalServices.repositories.BookingRepository;
import com.example.LocalServices.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LocalServicesApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBooking = bookingRepository.findByDateOfBooking(LocalDate.parse("2021-01-15"));
		assertEquals(LocalDate.parse("2021-01-15"), foundBooking.get(0).getDate_of_booking());
	}

}
