package com.omkcodes.cab_booking.controller;

import com.omkcodes.cab_booking.model.Booking;
import com.omkcodes.cab_booking.service.BookingService;

import java.util.Scanner;

public class BookingController {
    private static final Scanner scanner = new Scanner(System.in);
    private final BookingService bookingService = new BookingService();  // Create an instance of BookingService

    public void run() {
        int option = 0;
        do {
            System.out.println("Please select an option from below list:");
            System.out.println("1. Create a new booking");
            System.out.println("2. Show all bookings");
            System.out.println("3. Display booking details");
            System.out.println("9. Go back to main menu");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    Booking newBooking = bookingService.createNewBooking();
                    System.out.println("Booking created: " + newBooking);
                    break;

                case 2:
                    bookingService.showAllBookings();
                    break;

                case 3:
                    System.out.println("Enter Booking ID to display details:");
                    String bookingId = scanner.nextLine();
                    Booking booking = bookingService.getBookingList().get(bookingId);
                    bookingService.displayBookingDetails(booking);
                    break;

                case 9:
                    System.out.println("Going back to main menu...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        while (option != 9);
    }
}
