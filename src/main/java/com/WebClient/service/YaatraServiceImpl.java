package com.WebClient.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.WebClient.binding.Passenger;
import com.WebClient.binding.Ticket;

@Service
public class YaatraServiceImpl implements YaatraServices {

	@Override
	public List<Ticket> getAllTicket() {
		String allurl = "http://localhost:5050/ticket/getAllTickets";

		Ticket[] ticket = WebClient.create().get().uri(allurl).retrieve().bodyToMono(Ticket[].class).block();

		System.out.println(ticket);
		List<Ticket> list = Arrays.asList(ticket);
		return list;
	}

	@Override
	public Ticket bookTicket(Passenger p) {

		Passenger p1 = new Passenger();
		p1.setName(p.getName());
		p1.setJourneryDate(p.getJourneryDate());
		p1.setSource(p.getSource());
		p1.setDestination(p.getDestination());
		p1.setTrainNum(p.getTrainNum());

		String ticUrl = "http://localhost:5050/ticket/bookTicket";


		Ticket ticket = WebClient.create().post().uri(ticUrl).bodyValue(p1).retrieve().bodyToMono(Ticket.class).block();

		return ticket;
	}

	@Override
	public String deleteTicket(Integer ticketId) {

		String delUrl = "http://localhost:5050/ticket/deleteTicket/{ticketId}";

		String delteTicket = WebClient.create().delete().uri(delUrl, ticketId).retrieve().bodyToMono(String.class)
				.block();
		return delteTicket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {

		String geturl = "http://localhost:5050/ticket/getTicket/{id}";
		Ticket getTicket = WebClient.create().get().uri(geturl, ticketId).retrieve().bodyToMono(Ticket.class).block();

		return getTicket;

	}

	@Override
	public Ticket updateTicket(Passenger passenger,Integer ticketId) {

		String updateUrl = "http://localhost:5050/ticket/updateTicket/{ticketId}";
		Map<String, Integer> ticketMap = new HashMap<>();
		ticketMap.put("id", ticketId);
		Passenger updatedPassenger = new Passenger();
		updatedPassenger.setJourneryDate(passenger.getJourneryDate());
		updatedPassenger.setName(passenger.getName());
		updatedPassenger.setPid(ticketId);
		updatedPassenger.setTrainNum(passenger.getTrainNum());
		updatedPassenger.setSource(passenger.getSource());
		updatedPassenger.setDestination(passenger.getDestination());

		Ticket ticket = WebClient.create().put().uri(updateUrl,ticketId).bodyValue(updatedPassenger).retrieve().bodyToMono(Ticket.class).block();
		return ticket;
	}

}
