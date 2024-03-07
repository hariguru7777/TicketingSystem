package com.cloudbees.ticketingsystem.dal;

import com.cloudbees.ticketingsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByTrainIdAndCoachNo(int trainId, int coachNo);

}

