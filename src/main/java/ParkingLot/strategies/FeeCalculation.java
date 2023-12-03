package ParkingLot.strategies;

import ParkingLot.models.Ticket;

import java.util.Date;

public interface FeeCalculation {

    abstract public Integer calulateFee(Date date, Ticket ticket);
}
