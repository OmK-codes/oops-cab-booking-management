package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Driver;
import com.omkcodes.cab_booking.service.DriverService;
import com.omkcodes.cab_booking.exception.InvalidDriverIDException;
import java.util.Scanner;

public class DriverController {
    private final Scanner scanner;
    private final DriverService driverService;
    public DriverController(Scanner scanner, DriverService driverService) {
        this.scanner = scanner;
        this.driverService = driverService;
    }
    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Add a new driver");
            System.out.println("2. Show all drivers");
            System.out.println("3. Display driver details");
            System.out.println("9. Go back to main menu :");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            switch (option) {
                case 1:
                    try {
                        System.out.println("Enter Driver ID:");
                        String driverId = scanner.nextLine();
                        System.out.println("Enter Driver Name:");
                        String driverName = scanner.nextLine();
                        System.out.println("Enter Phone Number:");
                        String phone = scanner.nextLine();
                        System.out.println("Enter License Number:");
                        String licenseNumber = scanner.nextLine();
                        System.out.println("Enter Total Trips:");
                        int totalTrips = Integer.parseInt(scanner.nextLine());
                        System.out.println("Is the driver online? (true/false):");
                        boolean onlineStatus = Boolean.parseBoolean(scanner.nextLine());
                        System.out.println("Enter Driver Status (ACTIVE/INACTIVE):");
                        String statusInput = scanner.nextLine();
                        Driver newDriver = driverService.createNewDriver(driverId, driverName, phone, licenseNumber, totalTrips, onlineStatus, statusInput);
                        System.out.println("Driver added: " + newDriver);
                    } catch (InvalidDriverIDException e) {
                        System.out.println("Error adding driver: " + e.getMessage());
                    }
                    break;
                case 2:
                    driverService.showAllDrivers();
                    break;
                case 3:
                    System.out.println("Enter Driver ID to display details:");
                    String driverIdToDisplay = scanner.nextLine();
                    Driver driver = driverService.getDriverList().get(driverIdToDisplay);
                    if (driver != null) {
                        driverService.displayDriverDetails(driver);
                    } else {
                        System.out.println("Driver not found.");
                    }
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