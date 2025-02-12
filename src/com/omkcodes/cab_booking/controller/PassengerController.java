package com.omkcodes.cab_booking.controller;

import com.omkcodes.cab_booking.model.Passenger;
import com.omkcodes.cab_booking.service.PassengerService;

import java.util.Scanner;

public class PassengerController {
    private static final Scanner scanner = new Scanner(System.in);
    private final PassengerService passengerService = new PassengerService();

    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Add a new passenger");
            System.out.println("2. Show all passengers");
            System.out.println("3. Display passenger details");
            System.out.println("9. Go back to main menu");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    Passenger newPassenger = passengerService.addNewPassenger();
                    System.out.println("Passenger added: " + newPassenger);
                    break;

                case 2:
                    passengerService.showAllPassengers();
                    break;

                case 3:
                    System.out.println("Enter Passenger ID to display details:");
                    String passengerId = scanner.nextLine();
                    Passenger passenger = passengerService.getPassengerList().get(passengerId);
                    passengerService.displayPassengerDetails(passenger);
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
