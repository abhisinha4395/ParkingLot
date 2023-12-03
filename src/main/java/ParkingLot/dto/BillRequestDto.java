package ParkingLot.dto;

import ParkingLot.models.Gate;
import ParkingLot.models.Ticket;

public class BillRequestDto {

    private Ticket ticket;

    private Long gateId;

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
