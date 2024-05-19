package org.contract;

import org.example.Vehicle;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public double getTotalPrice() {

        this.salesTaxAmount = getVehicleSold().getPrice() * 1.05;
        this.recordingFee = 100;
        this.processingFee = 0;

        if (getVehicleSold().getPrice() < 10000) {
            this.processingFee = 295;
        }else{
            this.processingFee = 495;
        }

        double totalPrice = getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;

        return totalPrice;

    }

    @Override
    public double getMonthlyPayment() {

        double monthlyPayment = 0;

        if (this.isFinanced && getVehicleSold().getPrice() >= 10000) {

            double totalInterest = getVehicleSold().getPrice() * 4.25;

            monthlyPayment = getVehicleSold().getPrice() + totalInterest / 48;

            return monthlyPayment;

        }else if (this.isFinanced && getVehicleSold().getPrice() < 10000){

            double totalInterest = getVehicleSold().getPrice() * 5.25;

            monthlyPayment = getVehicleSold().getPrice() + totalInterest / 24;

            return monthlyPayment;

        }

        return 0;
    }
}
