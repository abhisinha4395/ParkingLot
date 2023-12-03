package ParkingLot.strategies;

import ParkingLot.models.Ticket;

import java.util.Date;

public class DurationFeeCalculation implements FeeCalculation{
    private FixedFeeCalculation fixedFeeCalculation;

    public DurationFeeCalculation(FixedFeeCalculation fixedFeeCalculation){
        this.fixedFeeCalculation = fixedFeeCalculation;
    }
    @Override
    public Integer calulateFee(Date date, Ticket ticket) {
        int baseFee = fixedFeeCalculation.calulateFee(date, ticket);

        int diffInHours = (int)( (date.getTime() - ticket.getEntryTime().getTime())
                / (1000 * 60 * 60));

        if (diffInHours >= 2){
            baseFee += 20;
        }
        return baseFee;
    }
}
