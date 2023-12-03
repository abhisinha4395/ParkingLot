package ParkingLot.dto;

import ParkingLot.models.Bill;
import ParkingLot.models.PaymentMode;

public class PaymentRequestDto {

    private Bill bill;
    private PaymentMode paymentMode;

    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
