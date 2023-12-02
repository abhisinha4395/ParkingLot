package ParkingLot.strategies;

import ParkingLot.models.ParkingLot;
import ParkingLot.models.SlotAssignmentStrategy;

public class SlotAssignmentFactory {

    public static SlotAssignment getSlotType(SlotAssignmentStrategy slotAssignmentStrategy){
        if (slotAssignmentStrategy == SlotAssignmentStrategy.RANDOM){
            return new RandomSlotAssignment();
        } else if (slotAssignmentStrategy == SlotAssignmentStrategy.NEAREST) {
            return new NearestSlotAssignment();
        }
        return null;
    }
}
