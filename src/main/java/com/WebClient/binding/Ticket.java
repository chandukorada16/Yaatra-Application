package com.WebClient.binding;

import java.util.Date;


public class Ticket {

	private Integer ticketId;

	private String name;

	private String source;

	private String destination;

	private Date journeryDate;

	private Integer trainNum;

	private String ticketPnr;

	private String ticketStatus;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getJourneryDate() {
		return journeryDate;
	}

	public void setJourneryDate(Date journeryDate) {
		this.journeryDate = journeryDate;
	}

	public Integer getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(Integer trainNum) {
		this.trainNum = trainNum;
	}

	public String getTicketPnr() {
		return ticketPnr;
	}

	public void setTicketPnr(String ticketPnr) {
		this.ticketPnr = ticketPnr;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", name=" + name + ", source=" + source + ", destination=" + destination
				+ ", journeryDate=" + journeryDate + ", trainNum=" + trainNum + ", ticketPnr=" + ticketPnr
				+ ", ticketStatus=" + ticketStatus + "]";
	}

}
