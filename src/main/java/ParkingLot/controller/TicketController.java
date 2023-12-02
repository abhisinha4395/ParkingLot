package ParkingLot.controller;

import ParkingLot.dto.ResponseType;
import ParkingLot.models.Ticket;
import ParkingLot.service.TicketService;
import ParkingLot.dto.TicketRequestDto;
import ParkingLot.dto.TicketResponseDto;
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public TicketResponseDto issueTicket(TicketRequestDto ticketRequestDto){
        TicketResponseDto response = new TicketResponseDto();
        try{
            Ticket ticket = ticketService.issueTicket(ticketRequestDto.getEntryTime(),
                    ticketRequestDto.getGateId(), ticketRequestDto.getVehicleNumber(),
                    ticketRequestDto.getOwnerName(), ticketRequestDto.getVehicleType());

            response.setTicket(ticket);
            response.setResponseType(ResponseType.SUCCESS);
        }
        catch (Exception e) {
            response.setResponseType(ResponseType.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }
}
