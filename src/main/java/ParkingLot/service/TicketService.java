package ParkingLot.service;

import ParkingLot.Exceptions.GateNotFoundException;
import ParkingLot.models.*;
import ParkingLot.repo.GateRepository;
import ParkingLot.repo.ParkingLotRepository;
import ParkingLot.repo.TicketRepository;
import ParkingLot.repo.VehicleRepository;
import ParkingLot.strategies.SlotAssignmentFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository, TicketRepository ticketRepository,
                  ParkingLotRepository parkingLotRepository, VehicleRepository vehicleRepository){
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Ticket issueTicket(Date entryTime, Long gateId, String vehicleNo,
                              String ownerName, VehicleTypes vehicleType) throws GateNotFoundException {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(entryTime);

        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if (optionalGate.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleNo);
        vehicle.setVehicleType(vehicleType);
        vehicle.setName(ownerName);
        vehicleRepository.saveVehicle(vehicle);
        ticket.setVehicle(vehicle);

        SlotAssignmentStrategy slotAssignmentStrategy = parkingLotRepository.getParkingLotByGate(gate)
                .getSlotAssignmentStrategy();
        ParkingSlot parkingSlot = SlotAssignmentFactory.getSlotType(slotAssignmentStrategy)
                .assignSlot(gate, vehicleType);

        ticket.setParkingSlot(parkingSlot);

        ticket = ticketRepository.saveTicket(ticket);
        ticket.setNumber("Ticket-" + ticket.getId());

        return ticket;
    }
}
