package org.contract;

import org.example.Vehicle;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {

        return getMonthlyPayment() * 36;

    }

    @Override
    public double getMonthlyPayment() {

        double originalPrice = getVehicleSold().getPrice();
        this.expectedEndingValue = originalPrice * .5;
        this.leaseFee = originalPrice * .07;

        double deprecationFee = (originalPrice - this.expectedEndingValue) / 36;
        double moneyFactor = 4.0 / 2400;

        double financeFee = (originalPrice + this.expectedEndingValue) * moneyFactor;
        double leaseFeePerMonth = this.leaseFee / 36;

        double monthlyPayment = deprecationFee + financeFee + leaseFeePerMonth;
        return monthlyPayment;
    }

}
