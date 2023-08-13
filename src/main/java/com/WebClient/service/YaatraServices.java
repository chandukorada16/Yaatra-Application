package com.WebClient.service;

import java.util.List;

import com.WebClient.binding.Passenger;
import com.WebClient.binding.Ticket;

public interface YaatraServices {

	public List<Ticket> getAllTicket();

	public Ticket bookTicket(Passenger p);

	public String deleteTicket(Integer ticketId);
	
	public Ticket getTicket(Integer ticketId);
	
	public Ticket updateTicket(Passenger passenger,Integer ticketId);
}
