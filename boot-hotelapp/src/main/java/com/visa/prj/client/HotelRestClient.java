package com.visa.prj.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.visa.prj.entity.Booking;

public class HotelRestClient {
	public static void main(String[] args) {
		String url = "http://localhost:8080/bookings";
		RestTemplate template = new RestTemplate();
		showBookings(template, url);
		showBookingList(template, url);
	}

	private static void showBookingList(RestTemplate template, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		ResponseEntity<List<Booking>> response = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Booking>>() {
		});
		response.getBody().forEach(booking-> System.out.println(booking.getUser().getUsername() + ", "+booking.getHotel().getName()));
	}

	private static void showBookings(RestTemplate template, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = template.getForObject(url, String.class);
		System.out.println(json);
	}
}
