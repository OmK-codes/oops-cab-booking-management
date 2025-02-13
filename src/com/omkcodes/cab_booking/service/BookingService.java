package com.omkcodes.cab_booking.service;
import com.omkcodes.cab_booking.enums.BookingStatus;
import com.omkcodes.cab_booking.exception.InvalidBookingIDException;
import com.omkcodes.cab_booking.model.Booking;
import java.util.HashMap;

public class BookingService {
    private final HashMap<String, Booking> bookingList = new HashMap<>();
    public void displayBookingDetails(Booking booking) {
        if (booking != null) {
            System.out.println(booking);
        } else {
            System.out.println("Booking details are not available.");
        }
    }
    public Booking createNewBooking(String bookingId, String passengerId, String passengerName,
                                    String driverId, String driverName, String vehicleId,
                                    String pickupLocation, String dropLocation, double fare,
                                    double distance, String statusInput)
            throws InvalidBookingIDException {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new InvalidBookingIDException("Booking ID cannot be null or empty.");
        }
        if (bookingList.containsKey(bookingId)) {
            throw new InvalidBookingIDException("Booking ID already exists. Please use a unique ID.");
        }
        Booking booking = new Booking();
        BookingStatus bookingStatus = BookingStatus.PENDING;
        try {
            bookingStatus = BookingStatus.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid booking status! Setting default to PENDING.");
        }
        booking.setBookingId(bookingId);
        booking.setPassengerId(passengerId);
        booking.setPassengerName(passengerName);
        booking.setDriverId(driverId);
        booking.setDriverName(driverName);
        booking.setVehicleId(vehicleId);
        booking.setPickupLocation(pickupLocation);
        booking.setDropLocation(dropLocation);
        booking.setFare(fare);
        booking.setDistance(distance);
        booking.setBookingStatus(bookingStatus);
        bookingList.put(bookingId, booking);
        return booking;
    }
    public void showAllBookings() {
        if (bookingList.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        for (Booking booking : bookingList.values()) {
            System.out.println("Booking Information: " + booking);
        }
    }
    public HashMap<String, Booking> getBookingList() {
        return bookingList;
    }
}
