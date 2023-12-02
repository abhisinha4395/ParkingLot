package ParkingLot.Exceptions;

import ParkingLot.repo.GateRepository;

public class GateNotFoundException extends Exception{
    public GateNotFoundException(){
        super("Gate not available");
    }
}
