package com.cloudbees.ticketingsystem.service;

import com.cloudbees.ticketingsystem.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TicketingService {

    Ticket createTicket(Ticket ticket);

    Ticket getTicket(int ticketId);

    Ticket cancelTicket(int ticketId);

    Ticket modifyTicket(int ticketId, int coachNo, int seatNo);

    List<Ticket> getAllTicketsBySection(int trainId, int sectionId);
}
