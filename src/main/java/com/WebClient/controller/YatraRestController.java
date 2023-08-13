package com.WebClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebClient.binding.Passenger;
import com.WebClient.binding.Ticket;
import com.WebClient.service.YaatraServices;

@RestController
@RequestMapping("/Yaatra")
public class YatraRestController {

	@Autowired
	private YaatraServices services;

	@GetMapping(value = "/alltickets", produces = { "application/json" })
	public ResponseEntity<List<Ticket>> getticket() {
		List<Ticket> allTicket = services.getAllTicket();

		return new ResponseEntity<List<Ticket>>(allTicket, HttpStatus.OK);

	}

	@PostMapping(value = "/bookTicket", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p) {

		Ticket bookTicket = services.bookTicket(p);

		return new ResponseEntity<Ticket>(bookTicket, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId) {

		String deleteTicket = services.deleteTicket(ticketId);

		return new ResponseEntity<String>(deleteTicket, HttpStatus.OK);

	}

	@GetMapping("/getTicket/{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId) {
		Ticket ticket = services.getTicket(ticketId);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

	@PutMapping("/updateTicket/{id}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Passenger passenger, @PathVariable("id") Integer ticketId) {

		Ticket updateTicket = services.updateTicket(passenger, ticketId);
		return new ResponseEntity<Ticket>(updateTicket, HttpStatus.OK);
	}

}
