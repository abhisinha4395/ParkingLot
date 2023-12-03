package ParkingLot.repo;

import ParkingLot.models.Payment;

import java.util.Map;
import java.util.TreeMap;

public class PaymentRepository {

    private long prevId = 0;
    private Map<Long, Payment> payments = new TreeMap<>();

    public Payment savePayment(Payment payment){
        prevId++;
        payment.setId(prevId);
        payment.setRefNumber("Ref-" + prevId);
        payments.put(prevId, payment);
        return payment;
    }
}
