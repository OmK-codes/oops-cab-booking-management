package com.omkcodes.cab_booking.service;
import com.omkcodes.cab_booking.exception.InvalidPassengerIDException;
import com.omkcodes.cab_booking.enums.PassengerStatus;
import com.omkcodes.cab_booking.model.Passenger;
import java.util.HashMap;

public class PassengerService {
    private final HashMap<String, Passenger> passengerList = new HashMap<>();
    public void displayPassengerDetails(Passenger passenger) {
        if (passenger != null) {
            System.out.println(passenger);
        } else {
            System.out.println("Passenger details are not available.");
        }
    }
    public Passenger createNewPassenger(String passengerId, String passengerName,
                                        String email, String phone,
                                        String address, String statusInput) throws InvalidPassengerIDException {
        if (passengerId == null || passengerId.trim().isEmpty()) {
            throw new InvalidPassengerIDException("Passenger ID cannot be null or empty.");
        }
        if (passengerList.containsKey(passengerId)) {
            throw new InvalidPassengerIDException("Passenger ID already exists. Please use a unique ID.");
        }
        Passenger passenger = new Passenger();
        PassengerStatus passengerStatus = PassengerStatus.ACTIVE;
        try {
            passengerStatus = PassengerStatus.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid passenger status! Setting default to ACTIVE.");
        }
        passenger.setPassengerId(passengerId);
        passenger.setPassengerName(passengerName);
        passenger.setEmail(email);
        passenger.setPhone(phone);
        passenger.setAddress(address);
        passenger.setPassengerStatus(passengerStatus);
        passengerList.put(passenger.getPassengerId(), passenger);
        return passenger;
    }
    public void showAllPassengers() {
        if (passengerList.isEmpty()) {
            System.out.println("No passengers available.");
            return;
        }
        for (Passenger passenger : passengerList.values()) {
            System.out.println("Passenger Information: " + passenger);
        }
    }
    public HashMap<String, Passenger> getPassengerList() {
        return passengerList;
    }
}