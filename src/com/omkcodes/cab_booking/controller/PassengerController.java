package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Passenger;
import com.omkcodes.cab_booking.service.PassengerService;
import com.omkcodes.cab_booking.exception.InvalidPassengerIDException;
import java.util.Scanner;

public class PassengerController {
    private final Scanner scanner;
    private final PassengerService passengerService;
    public PassengerController(Scanner scanner, PassengerService passengerService) {
        this.scanner = scanner;
        this.passengerService = passengerService;
    }
    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Add a new passenger");
            System.out.println("2. Show all passengers");
            System.out.println("3. Display passenger details");
            System.out.println("9. Go back to main menu");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("Enter Passenger ID:");
                    String passengerId = scanner.nextLine();
                    System.out.println("Enter Passenger Name:");
                    String passengerName = scanner.nextLine();
                    System.out.println("Enter Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter Phone:");
                    String phone = scanner.nextLine();
                    System.out.println("Enter Address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter Status (ACTIVE, INACTIVE, BANNED):");
                    String statusInput = scanner.nextLine();
                    try {
                        Passenger newPassenger = passengerService.createNewPassenger(passengerId, passengerName, email, phone, address, statusInput);
                        System.out.println("Passenger added: " + newPassenger);
                    } catch (InvalidPassengerIDException e) {
                        System.out.println("Error adding passenger: " + e.getMessage());
                    }
                    break;
                case 2:
                    passengerService.showAllPassengers();
                    break;
                case 3:
                    System.out.println("Enter Passenger ID to display details:");
                    String passengerIdToDisplay = scanner.nextLine();
                    Passenger passenger = passengerService.getPassengerList().get(passengerIdToDisplay);
                    if (passenger != null) {
                        passengerService.displayPassengerDetails(passenger);
                    } else {
                        System.out.println("Passenger ID not found.");
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
