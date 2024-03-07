package com.cloudbees.ticketingsystem.controller;

import com.cloudbees.ticketingsystem.model.Seat;
import com.cloudbees.ticketingsystem.model.Ticket;
import com.cloudbees.ticketingsystem.service.TicketingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ticket Booking Service", description = "APIs for managing tickets.")
@RestController
public class TicketingController {

    @Autowired
    TicketingService ticketingService;

    @PostMapping("/tickets")
    public Ticket purchaseTicket(@RequestBody Ticket ticket) {
        return ticketingService.createTicket(ticket);
    }

    @GetMapping("/tickets/{ticketId}")
    public Ticket getTicket(@PathVariable int ticketId) {
        return ticketingService.getTicket(ticketId);
    }

    @DeleteMapping("/tickets/{ticketId}")
    public Ticket cancelTicket(@PathVariable int ticketId) {
        return ticketingService.cancelTicket(ticketId);
    }

    @PatchMapping("/tickets/{ticketId}")
    public Ticket modifyTicket(@PathVariable int ticketId, @RequestBody Seat seat) {
        return ticketingService.modifyTicket(ticketId, seat.getSectionNo(), seat.getSeatNo());
    }

    @GetMapping("/tickets/train/{trainId}/section/{section}")
    public List<Ticket> getAllTicketsBySection(@PathVariable int trainId,
                                               @PathVariable int section) {
        return ticketingService.getAllTicketsBySection(trainId, section);
    }


}
