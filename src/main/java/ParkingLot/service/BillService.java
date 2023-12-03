package ParkingLot.service;

import ParkingLot.Exceptions.GateNotFoundException;
import ParkingLot.models.*;
import ParkingLot.repo.BillRepository;
import ParkingLot.repo.GateRepository;
import ParkingLot.repo.ParkingLotRepository;
import ParkingLot.strategies.FeeCalculationFactory;

import java.util.Date;
import java.util.Optional;

public class BillService {

    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private BillRepository billRepository;

    public BillService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository,
                       BillRepository billRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.billRepository = billRepository;
    }

    public Bill generateBill(Ticket ticket, long gateId) throws GateNotFoundException {
        Bill bill = new Bill();
        bill.setExitTime(new Date());
        bill.setTicket(ticket);

        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if (optionalGate.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate = optionalGate.get();
        bill.setGeneratedAt(gate);
        bill.setGeneratedBy(gate.getOperator());

        bill.setBillStatus(BillStatus.UNPAID);

        FeeCalculationStrategy feeCalculationStrategy = parkingLotRepository.getParkingLotByGate(gate)
                .getFeeCalculationStrategy();
        int amount = FeeCalculationFactory.getFeeType(feeCalculationStrategy)
                .calulateFee(bill.getExitTime(), ticket);

        bill.setAmount(amount);
        bill = billRepository.saveBill(bill);
        return bill;
    }

    public void updateBill(long billId, Payment payment){
        billRepository.updatePaymentInfo(billId, payment);
    }
}
