package ParkingLot.repo;

import ParkingLot.models.Bill;
import ParkingLot.models.BillStatus;
import ParkingLot.models.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BillRepository {
    private long prevId = 0;
    private Map<Long, Bill> bills = new TreeMap<>();

    public Bill saveBill(Bill bill){
        prevId++;
        bill.setId(prevId);
        bill.setPayments(new ArrayList<>());
        bills.put(prevId, bill);
        return bill;
    }

    public void updatePaymentInfo(long billId, Payment payment){
        Bill bill = bills.get(billId);
        bill.setBillStatus(BillStatus.PAID);

        List<Payment> payments = bill.getPayments();
        payments.add(payment);
        bill.setPayments(payments);

    }
}
