package ParkingLot.repo;

import ParkingLot.models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TicketRepository {
    private long prevId = 0;
    private Map<Long, Ticket> tickets = new TreeMap<>();

    public Ticket saveTicket(Ticket ticket){
        prevId++;
        ticket.setId(prevId);
        tickets.put(prevId, ticket);
        return ticket;
    }
}
