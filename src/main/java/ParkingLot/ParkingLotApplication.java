package ParkingLot;

import ParkingLot.controller.BillController;
import ParkingLot.controller.PaymentController;
import ParkingLot.controller.TicketController;
import ParkingLot.dto.*;
import ParkingLot.models.PaymentMode;
import ParkingLot.models.VehicleTypes;
import ParkingLot.repo.*;
import ParkingLot.service.BillService;
import ParkingLot.service.PaymentService;
import ParkingLot.service.TicketService;

import java.util.Date;

public class ParkingLotApplication {

    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        BillRepository billRepository = new BillRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

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

        BillService billService = new BillService(gateRepository, parkingLotRepository,
                billRepository);

        BillRequestDto billRequestDto = new BillRequestDto();
        billRequestDto.setGateId((long) 2);
        billRequestDto.setTicket(ticketResponseDto.getTicket());

        BillController billController = new BillController(billService);
        BillResponseDto billResponseDto = billController.generateBill(billRequestDto);
        System.out.println(billResponseDto.getResponseType());

        PaymentRequestDto paymentRequestDto = new PaymentRequestDto();
        PaymentResponseDto paymentResponseDto;
        do {
            PaymentController paymentController = new PaymentController(
                    new PaymentService(paymentRepository));
            // Hard coded now, but should be taken as user input
            paymentRequestDto.setPaymentMode(PaymentMode.CASH);
            paymentRequestDto.setBill(billResponseDto.getBill());
            paymentRequestDto.setAmount(10);

             paymentResponseDto = paymentController.initiatePayment(paymentRequestDto);
        } while (billResponseDto.getBill().getAmount() - paymentRequestDto.getAmount() > 0);
        System.out.println(paymentResponseDto.getResponseType());

    }
}
