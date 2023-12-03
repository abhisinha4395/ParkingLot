package ParkingLot.controller;

import ParkingLot.dto.BillRequestDto;
import ParkingLot.dto.BillResponseDto;
import ParkingLot.dto.ResponseType;
import ParkingLot.models.Bill;
import ParkingLot.service.BillService;

public class BillController {

    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public BillResponseDto generateBill(BillRequestDto billRequestDto) {
        BillResponseDto responseDto = new BillResponseDto();
        try {
            Bill bill = billService.generateBill(billRequestDto.getTicket(),
                    billRequestDto.getGateId());
            responseDto.setResponseType(ResponseType.SUCCESS);
            responseDto.setBill(bill);
        } catch (Exception e) {
            responseDto.setFailureMessage("Bill creation Failed");
            responseDto.setResponseType(ResponseType.FAILURE);
        }
        return responseDto;
    }
}
