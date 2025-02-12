package com.omkcodes.cab_booking.controller;

import com.omkcodes.cab_booking.model.Vehicle;
import com.omkcodes.cab_booking.service.VehicleService;

import java.util.Scanner;

public class VehicleController {
    private static final Scanner scanner = new Scanner(System.in);
    private final VehicleService vehicleService = new VehicleService();

    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Show all vehicles");
            System.out.println("3. Display vehicle details");
            System.out.println("9. Go back to main menu");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    Vehicle newVehicle = vehicleService.addNewVehicle();
                    System.out.println("Vehicle added: " + newVehicle);
                    break;

                case 2:
                    vehicleService.showAllVehicles();
                    break;

                case 3:
                    System.out.println("Enter Vehicle ID to display details:");
                    String vehicleId = scanner.nextLine();
                    Vehicle vehicle = vehicleService.getVehicleList().get(vehicleId);
                    vehicleService.displayVehicleDetails(vehicle);
                    break;

                case 9:
                    System.out.println("Going back to main menu...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 9);
    }
}
