package com.visa.prj.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.User;

public interface BookingDao extends JpaRepository<Booking, Long> {
	@Query("from Booking b where b.user = :u")
	List<Booking> getAllBookingsOfUser(@Param("u") User user);
}
