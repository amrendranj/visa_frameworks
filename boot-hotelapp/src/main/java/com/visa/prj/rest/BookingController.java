package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@RestController
@RequestMapping("bookings")
public class BookingController {
	@Autowired
	private BookingService service;

	@GetMapping
	public @ResponseBody List<Booking> getBookings(@RequestParam(name = "user", required = false) String userName) {
		if (userName != null) {
			return service.getBookingsByUser(userName);
		} else {
			return service.getAllBookings();
		}
	}

	@PostMapping
	public ResponseEntity<Booking> addBooking(@RequestBody Booking b) {
		service.bookHotel(b);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}
}
