package ParkingLot.strategies;

import ParkingLot.models.FeeCalculationStrategy;

public class FeeCalculationFactory {

    public static FeeCalculation getFeeType(FeeCalculationStrategy feeCalculationStrategy){
        if (feeCalculationStrategy == FeeCalculationStrategy.FIXED){
            return new FixedFeeCalculation();
        } else if (feeCalculationStrategy == FeeCalculationStrategy.DURATION) {
            return new DurationFeeCalculation(new FixedFeeCalculation());
        }
        return null;
    }
}
