package com.omkcodes.cab_booking.controller;

import com.omkcodes.cab_booking.model.Driver;
import com.omkcodes.cab_booking.service.DriverService;

import java.util.Scanner;

public class DriverController {
    private static final Scanner scanner = new Scanner(System.in);
    private final DriverService driverService = new DriverService();

    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Add a new driver");
            System.out.println("2. Show all drivers");
            System.out.println("3. Display driver details");
            System.out.println("9. Go back to main menu");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    Driver newDriver = driverService.addNewDriver();
                    System.out.println("Driver added: " + newDriver);
                    break;
                case 2:
                    driverService.showAllDrivers();
                    break;
                case 3:
                    System.out.println("Enter Driver ID to display details:");
                    String driverId = scanner.nextLine();
                    Driver driver = driverService.getDriverList().get(driverId);
                    driverService.displayDriverDetails(driver);
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
