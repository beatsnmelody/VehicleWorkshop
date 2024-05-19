package org.contract;

import org.example.Dealership;
import org.example.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {

    public static List<Contract> readContracts(Contract contract){

        List<Contract> contracts = new ArrayList<>();

        String filePath = "src/main/resources/contracts.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = reader.readLine()) != null){

                String[] data = line.split("\\|");

                if (contract instanceof SalesContract) {
                    String date = data[0];
                    String name = data[1];
                    String email = data[2];

                }

            }

        }catch(IOException ex){
            System.out.println("Whoops, can't read that dealership!");
        }

        return contracts;
    }

    public static void writeContractToFile(Contract contract, Vehicle vehicle){

        String filePath = "src/main/resources/contracts.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){

            if (contract instanceof SalesContract){

                writer.write(contract.getDateOfContract() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +  vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee() + "|" + ((SalesContract) contract).isFinanced() + "|" + contract.getMonthlyPayment());

                writer.newLine();

                System.out.println("Added sales contract to the list!");

            }

            if (contract instanceof LeaseContract){

                writer.write(contract.getDateOfContract() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +  vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getMonthlyPayment());

                writer.newLine();

                System.out.println("Added lease contract to the list!");

            }


        }catch(IOException ex){

            System.out.println("Whoops, can't add that contract!");
        }

    }

}
