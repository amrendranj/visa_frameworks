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

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

@RestController
@RequestMapping("hotels")
public class HotelController {
	@Autowired
	private BookingService service;
	
	@GetMapping
	public @ResponseBody List<Hotel> getHotels(@RequestParam(name = "search", required = false)String criteria){
		if(criteria == null) {
			return service.getAllHotels();
		}
		else {
			return service.searchHotels(criteria);
		}
	}
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel h){
		service.addHotel(h);
		return new ResponseEntity<>(h,HttpStatus.CREATED);
	}
	
}
