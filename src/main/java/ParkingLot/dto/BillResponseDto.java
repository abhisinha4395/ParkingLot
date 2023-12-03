package ParkingLot.dto;

import ParkingLot.models.Bill;

public class BillResponseDto {

    private Bill bill;
    private ResponseType responseType;
    private String FailureMessage;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public String getFailureMessage() {
        return FailureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        FailureMessage = failureMessage;
    }
}
