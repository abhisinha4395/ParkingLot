package ParkingLot.strategies;

import ParkingLot.models.Ticket;
import ParkingLot.models.VehicleTypes;

import java.util.Date;

public class FixedFeeCalculation implements FeeCalculation{

    @Override
    public Integer calulateFee(Date date, Ticket ticket) {
        VehicleTypes vehicleType = ticket.getVehicle().getVehicleType();
        if (vehicleType == VehicleTypes.BICYCLE){
            return 5;
        } else if (vehicleType == VehicleTypes.BIKE) {
            return 10;
        } else if (vehicleType == VehicleTypes.CAR) {
            return 20;
        } else if (vehicleType == VehicleTypes.BUS) {
            return 50;
        }
        return 0;
    }
}
