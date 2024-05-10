package org.example;

import java.util.List;
import java.util.Scanner;

public class Interface {

    private Dealership dealership;

    private void init(){

        List<Dealership> dealerships = FileManager.getDealership();

        this.dealership = dealerships.get(0);

    }

    public void homeScreen(){

        while(true){

            init();

            System.out.println("""
                                               _.-="_-         _
                                             _.-="   _-          | ||""\"""\""---._______     __..
                                 ___.===""\""-.______-,,,,,,,,,,,,`-''----" ""\"""       ""\"""  __'
                          __.--""     __        ,'                   o \\           __        [__|
                     __-""=======.--""  ""--.=================================.--""  ""--.=======:
                    ]       [w] : /        \\ : |========================|    : /        \\ :  [w] :
                    V___________:|          |: |========================|    :|          |:   _-"
                     V__________: \\        / :_|=======================/_____: \\        / :__-"
                     -----------'  "-____-"  `-------------------------------'  "-____-"
                    """);

            System.out.println("\nWelcome to the inventory manager of " + dealership.getName() +", esteemed employee!");

            System.out.println("Now, what would you like to do? Select a number to get started.");

            System.out.println("""
                    1) Find Vehicles By Price Range
                    2) Find Vehicles By Make/Model
                    3) Find Vehicles By Year Range
                    4) Find Vehicles By Color
                    5) Find Vehicles By Mileage Range
                    6) Find Vehicles By Vehicle Type
                    7) List All Vehicles
                    8) Add A Vehicle
                    9) Remove A Vehicle
                    99) Quit
                    """);

            Scanner userInput = new Scanner(System.in);

            int homeScreenInput = Integer.parseInt(userInput.nextLine());

            switch(homeScreenInput){
                case 1:
                    processGetByPriceRequest(true);
                    break;
                case 2:
                    processGetByMakeModelRequest(true);
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    System.out.println("Under construction!");
                    break;
                case 6:
                    System.out.println("Under construction!");
                    break;
                case 7:
                    System.out.println("Under construction!");
                    break;
                case 8:
                    System.out.println("Under construction!");
                    break;
                case 9:
                    System.out.println("Under construction!");
                    break;
                case 99:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Oops, that's not an option!");
            }

        }

    }

    public void processGetByPriceRequest(boolean isEnabled){

        while(isEnabled){

            Scanner userInput = new Scanner(System.in);

            System.out.println("Here is where you filter vehicles by price.\n");

            System.out.println("Enter minimum price:");

            double min = Double.parseDouble(userInput.nextLine());

            System.out.println("Enter maximum price:");

            double max = Double.parseDouble(userInput.nextLine());

            System.out.println("Here are all vehicles within your price range.\n");

            System.out.println(dealership.getVehiclesByPrice(min, max));

            isEnabled = false;

        }

    }

    public void processGetByMakeModelRequest(boolean isEnabled){

        while(isEnabled) {

            Scanner userInput = new Scanner(System.in);

            System.out.println("Here's where you filter vehicles by make and model.");

            System.out.println("Enter the vehicle make here:");

            String make = userInput.nextLine();

            System.out.println("Enter the vehicle model here:");

            String model = userInput.nextLine();

            System.out.println(dealership.getVehiclesByMakeModel(make, model));

            isEnabled = false;

        }

    }

    public void processGetByYearRequest() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Here is where you filter vehicles by year.");
        System.out.println("Enter the vehicle year here:");
        int year = userInput.nextInt();
        dealership.getVehiclesByYear(year);
    }

    public void processGetByColorRequest() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Here is where you filter vehicles by color.");
        System.out.println("Enter the vehicle color here:");
        String color = userInput.nextLine();
        System.out.println(dealership.getVehiclesByColor(color));
    }
}