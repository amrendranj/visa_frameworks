package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.dao.HotelDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private UserDao userDao;

	@Transactional
	public void bookHotel(Booking b) {
		System.out.println(b);
		bookingDao.save(b);
	}

	@Transactional
	public void addHotel(Hotel h) {
		hotelDao.save(h);
	}

	public List<Booking> getAllBookings() {
		return bookingDao.findAll();
	}

	public List<Hotel> getAllHotels() {
		// System.out.println(hotelDao.findAll().get(0));
		return hotelDao.findAll();
	}

	public List<Hotel> searchHotels(String criteria) {
		return hotelDao.searchHotels(criteria);
	}

	public List<Booking> getBookingsByUser(String username) {
		User u = userDao.findById(username).get();
		return bookingDao.getAllBookingsOfUser(u);
	}
}
