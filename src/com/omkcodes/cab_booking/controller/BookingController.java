package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Booking;
import com.omkcodes.cab_booking.service.BookingService;
import com.omkcodes.cab_booking.exception.InvalidBookingIDException;
import java.util.Scanner;

public class BookingController {
    private static final Scanner scanner = new Scanner(System.in);
    private final BookingService bookingService = new BookingService();
    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Create a new booking");
            System.out.println("2. Show all bookings");
            System.out.println("3. Display booking details");
            System.out.println("9. Go back to main menu :");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("Enter Booking ID:");
                    String bookingId = scanner.nextLine().trim();
                    System.out.println("Booking ID entered: '" + bookingId + "'");
                    if (bookingId == null || bookingId.isEmpty()) {
                        System.out.println("Error: Booking ID cannot be null or empty.");
                        break;
                    }
                    System.out.println("Enter Driver ID:");
                    String driverId = scanner.nextLine();
                    System.out.println("Enter Passenger ID:");
                    String passengerId = scanner.nextLine();
                    System.out.println("Enter Vehicle ID:");
                    String vehicleId = scanner.nextLine();
                    System.out.println("Enter Pickup Location:");
                    String pickupLocation = scanner.nextLine();
                    System.out.println("Enter Drop Location:");
                    String dropLocation = scanner.nextLine();
                    System.out.println("Enter Distance (in km):");
                    double distance = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter Fare Amount:");
                    double fareAmount = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter Booking Status:");
                    String bookingStatus = scanner.nextLine();
                    try {
                        Booking newBooking = bookingService.createNewBooking(bookingId, passengerId,
                                "Passenger Name", driverId,
                                "Driver Name", vehicleId, pickupLocation, dropLocation,
                                fareAmount, distance, bookingStatus);
                        System.out.println("Booking created: " + newBooking);
                    } catch (InvalidBookingIDException e) {
                        System.out.println("Error creating booking: " + e.getMessage());
                    }
                    break;
                case 2:
                    bookingService.showAllBookings();
                    break;
                case 3:
                    System.out.println("Enter Booking ID to display details:");
                    String bookingIdToDisplay = scanner.nextLine();
                    Booking booking = bookingService.getBookingList().get(bookingIdToDisplay);
                    if (booking != null) {
                        bookingService.displayBookingDetails(booking);
                    } else {
                        System.out.println("Booking ID not found.");
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
