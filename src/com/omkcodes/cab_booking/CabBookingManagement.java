package com.omkcodes.cab_booking;
import com.omkcodes.cab_booking.controller.DriverController;
import com.omkcodes.cab_booking.controller.PassengerController;
import com.omkcodes.cab_booking.controller.VehicleController;
import com.omkcodes.cab_booking.controller.BookingController;
import com.omkcodes.cab_booking.service.DriverService;
import com.omkcodes.cab_booking.service.PassengerService;
import com.omkcodes.cab_booking.service.VehicleService;
import com.omkcodes.cab_booking.service.BookingService;
import java.util.Scanner;

public class CabBookingManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DriverService driverService = new DriverService();
        PassengerService passengerService = new PassengerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();

        // Initialized controllers here instead of initialization in every controller class
        DriverController driverController = new DriverController(scanner, driverService);
        PassengerController passengerController = new PassengerController(scanner, passengerService);
        VehicleController vehicleController = new VehicleController(scanner, vehicleService);
        BookingController bookingController = new BookingController();
        int mainOption = 0;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Drivers");
            System.out.println("2. Manage Passengers");
            System.out.println("3. Manage Vehicles");
            System.out.println("4. Manage Bookings");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            try {
                mainOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }
            switch (mainOption) { // here called every controller
                case 1:
                    driverController.run();
                    break;
                case 2:
                    passengerController.run();
                    break;
                case 3:
                    vehicleController.run();
                    break;
                case 4:
                    bookingController.run();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (mainOption != 0);
    }
}