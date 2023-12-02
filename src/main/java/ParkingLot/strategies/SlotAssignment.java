package ParkingLot.strategies;

import ParkingLot.models.Gate;
import ParkingLot.models.ParkingSlot;
import ParkingLot.models.VehicleTypes;

public interface SlotAssignment {

    abstract public ParkingSlot assignSlot(Gate gate, VehicleTypes vehicleTypes);
}
