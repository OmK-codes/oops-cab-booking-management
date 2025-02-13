package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Vehicle;
import com.omkcodes.cab_booking.service.VehicleService;
import com.omkcodes.cab_booking.exception.InvalidVehicleIDException;
import java.util.Scanner;

public class VehicleController {
    private final Scanner scanner;
    private final VehicleService vehicleService;
    public VehicleController(Scanner scanner, VehicleService vehicleService) {
        this.scanner = scanner;
        this.vehicleService = vehicleService;
    }
    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from the list below:");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Show all vehicles");
            System.out.println("3. Display vehicle details");
            System.out.println("9. Go back to main menu");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("Enter Vehicle ID:");
                    String vehicleId = scanner.nextLine();
                    System.out.println("Enter Vehicle Model:");
                    String vehicleModel = scanner.nextLine();
                    System.out.println("Enter Registration Number:");
                    String registrationNumber = scanner.nextLine();
                    System.out.println("Enter Vehicle Color:");
                    String vehicleColor = scanner.nextLine();
                    System.out.println("Enter Availability (true/false):");
                    boolean availability = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("Enter Seat Capacity:");
                    int seatCapacity = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter Per Km Rate:");
                    double perKmRate = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter Vehicle Status (AVAILABLE/UNAVAILABLE):");
                    String statusInput = scanner.nextLine();
                    try {
                        Vehicle newVehicle = vehicleService.createNewVehicle(vehicleId, vehicleModel,
                                registrationNumber, vehicleColor, availability, seatCapacity,
                                perKmRate, statusInput);
                        System.out.println("Vehicle added: " + newVehicle);
                    } catch (InvalidVehicleIDException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    vehicleService.showAllVehicles();
                    break;
                case 3:
                    System.out.println("Enter Vehicle ID to display details:");
                    String vehicleIdToShow = scanner.nextLine();
                    Vehicle vehicle = vehicleService.getVehicleList().get(vehicleIdToShow);
                    vehicleService.displayVehicleDetails(vehicle);
                    break;
                case 9:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 9);
    }
}