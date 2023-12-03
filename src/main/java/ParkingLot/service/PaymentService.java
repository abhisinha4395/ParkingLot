package ParkingLot.service;

import ParkingLot.models.Bill;
import ParkingLot.models.Payment;
import ParkingLot.models.PaymentMode;
import ParkingLot.repo.BillRepository;
import ParkingLot.repo.PaymentRepository;

import java.util.Date;

public class PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentService( PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment initiatePayment(Bill bill, PaymentMode paymentMode, int amount){
        Payment payment = new Payment();
        payment.setPaymentMode(paymentMode);
        payment.setAmount(amount);
        payment.setBill(bill);
        payment.setDate(new Date());
        payment = paymentRepository.savePayment(payment);
        return payment;
    }
}
