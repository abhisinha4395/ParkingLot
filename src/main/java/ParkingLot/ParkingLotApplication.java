package ParkingLot;

import ParkingLot.controller.TicketController;
import ParkingLot.dto.TicketRequestDto;
import ParkingLot.dto.TicketResponseDto;
import ParkingLot.models.VehicleTypes;
import ParkingLot.repo.GateRepository;
import ParkingLot.repo.ParkingLotRepository;
import ParkingLot.repo.TicketRepository;
import ParkingLot.repo.VehicleRepository;
import ParkingLot.service.TicketService;

import java.util.Date;

public class ParkingLotApplication {

    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository, ticketRepository,
                parkingLotRepository, vehicleRepository);

        TicketRequestDto ticketRequestDto = new TicketRequestDto();
        ticketRequestDto.setGateId((long) 1);
        ticketRequestDto.setVehicleNumber("BR019866");
        ticketRequestDto.setVehicleType(VehicleTypes.BIKE);
        ticketRequestDto.setEntryTime(new Date());

        TicketController ticketController = new TicketController(ticketService);
        TicketResponseDto ticketResponseDto = ticketController.issueTicket(ticketRequestDto);
        System.out.println(ticketResponseDto.getResponseType());
    }
}
