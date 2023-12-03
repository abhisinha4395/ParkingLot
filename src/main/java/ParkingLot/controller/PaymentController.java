package ParkingLot.controller;

import ParkingLot.dto.PaymentRequestDto;
import ParkingLot.dto.PaymentResponseDto;
import ParkingLot.dto.ResponseType;
import ParkingLot.models.Payment;
import ParkingLot.service.PaymentService;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public PaymentResponseDto initiatePayment(PaymentRequestDto paymentRequestDto){
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        try{
            Payment payment = paymentService.initiatePayment(paymentRequestDto.getBill(),
                    paymentRequestDto.getPaymentMode(), paymentRequestDto.getAmount());
            paymentResponseDto.setResponseType(ResponseType.SUCCESS);
            paymentResponseDto.setPayment(payment);
        } catch (Exception e){
            paymentResponseDto.setResponseType(ResponseType.FAILURE);
            paymentResponseDto.setFailureMessage("Payment Failure");
        }
        return paymentResponseDto;
    }
}
