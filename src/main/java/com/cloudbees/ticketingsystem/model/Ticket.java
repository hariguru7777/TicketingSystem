package com.cloudbees.ticketingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 //   User user;
 //   Train train;
    int trainId;
    Station source;
    Station destination;
    OffsetDateTime dateTime;
 //   Seat seat;
    int coachNo;
    int seatNo;
    float price;
    TicketStatus status;
}
