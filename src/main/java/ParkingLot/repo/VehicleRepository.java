package ParkingLot.repo;

import ParkingLot.models.Vehicle;
import ParkingLot.models.VehicleTypes;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {

    private Map<String, Vehicle> vehicles = new TreeMap<>();

    public void saveVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicles.containsKey(vehicle.getVehicleNumber())){
            vehicles.remove(vehicle.getVehicleNumber());
        }
    }
}
