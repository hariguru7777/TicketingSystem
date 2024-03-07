package com.cloudbees.ticketingsystem.service.impl;

import com.cloudbees.ticketingsystem.dal.TicketRepository;
import com.cloudbees.ticketingsystem.model.Ticket;
import com.cloudbees.ticketingsystem.model.TicketStatus;
import com.cloudbees.ticketingsystem.service.TicketingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTicketingService implements TicketingService {

    Logger logger = LoggerFactory.getLogger(TrainTicketingService.class);

    @Autowired
    TicketRepository ticketRepository;
    /**
     * @param ticket
     * @return
     */
    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * @param ticketId
     * @return
     */
    @Override
    public Ticket getTicket(int ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    /**
     * @param ticketId
     * @return
     */
    @Override
    public Ticket cancelTicket(int ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null) {
            logger.info("No ticket exists with ticket id: {}" , ticketId);
            return null;
        }
        ticket.setStatus(TicketStatus.CANCELLED);
        ticketRepository.save(ticket);
        return ticket;
    }

    /**
     * @param ticketId
     * @return
     */
    @Override
    public Ticket modifyTicket(int ticketId, int coachNo, int seatNo) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null) {
            logger.info("No ticket exists with ticket id: {}" , ticketId);
            return null;
        }
        ticket.setCoachNo(coachNo);
        ticket.setSeatNo(seatNo);
        ticketRepository.save(ticket);
        return ticket;
    }

    /**
     * @param sectionId
     * @return
     */
    @Override
    public List<Ticket> getAllTicketsBySection(int trainId, int sectionId) {
        List<Ticket> tickets = ticketRepository.findByTrainIdAndCoachNo(trainId,sectionId);
        if (tickets == null) {
            logger.info("No tickets booked for train: {} section: {}" , trainId, sectionId);
            return null;
        }
        return tickets;
    }
}
