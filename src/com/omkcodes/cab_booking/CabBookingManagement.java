package com.omkcodes.cab_booking;

import com.omkcodes.cab_booking.model.Booking;
import com.omkcodes.cab_booking.model.Driver;
import com.omkcodes.cab_booking.model.Passenger;
import com.omkcodes.cab_booking.model.Vehicle;
import com.omkcodes.cab_booking.service.BookingService;
import com.omkcodes.cab_booking.service.DriverService;
import com.omkcodes.cab_booking.service.PassengerService;
import com.omkcodes.cab_booking.service.VehicleService;
import java.util.Scanner;

public class CabBookingManagement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        DriverService driverService = new DriverService();
        PassengerService passengerService = new PassengerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();

        do {
            System.out.println("\n--- Cab Booking Management System ---");
            System.out.println("1. Create Passenger");
            System.out.println("2. Create Driver");
            System.out.println("3. Create Vehicle");
            System.out.println("4. Create Booking");
            System.out.println("5. Show All Passengers");
            System.out.println("6. Show All Drivers");
            System.out.println("7. Show All Vehicles");
            System.out.println("8. Show All Bookings");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    Passenger passenger = passengerService.createNewPassenger();
                    System.out.println("Passenger created: " + passenger);
                    break;

                case 2:
                    Driver driver = driverService.createNewDriver();
                    System.out.println("Driver created: " + driver);
                    break;

                case 3:
                    Vehicle vehicle = vehicleService.createNewVehicle();
                    System.out.println("Vehicle created: " + vehicle);
                    break;

                case 4:
                    createBooking(driverService, passengerService, vehicleService, bookingService);
                    break;

                case 5:
                    passengerService.showAllPassengers();
                    break;

                case 6:
                    driverService.showAllDrivers();
                    break;

                case 7:
                    vehicleService.showAllVehicles();
                    break;

                case 8:
                    bookingService.showAllBookings();
                    break;

                case 0:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (option != 0);

        System.out.println("KEEP TRAVELLING!");
    }

    private static void createBooking(DriverService driverService, PassengerService passengerService, VehicleService vehicleService, BookingService bookingService) {
        System.out.println("Enter Booking ID:");
        String bookingId = sc.nextLine();
        System.out.println("Enter Driver ID:");
        String driverId = sc.nextLine();
        System.out.println("Enter Passenger ID:");
        String passengerId = sc.nextLine();
        System.out.println("Enter Vehicle ID:");
        String vehicleId = sc.nextLine();

        if (!driverService.getDriverList().containsKey(driverId)) {
            System.out.println("Error: Invalid Driver ID.");
            return;
        }
        if (!passengerService.getPassengerList().containsKey(passengerId)) {
            System.out.println("Error: Invalid Passenger ID.");
            return;
        }
        if (!vehicleService.getVehicleList().containsKey(vehicleId)) {
            System.out.println("Error: Invalid Vehicle ID.");
            return;
        }

        Booking booking = bookingService.createNewBooking();
        booking.setBookingId(bookingId);
        booking.setDriverId(driverId);
        booking.setPassengerId(passengerId);
        booking.setVehicleId(vehicleId);
        System.out.println("Booking created: " + booking);
    }
}
