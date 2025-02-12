package com.omkcodes.cab_booking.service;

import com.omkcodes.cab_booking.enums.VehicleStatus;
import com.omkcodes.cab_booking.model.Vehicle;

import java.util.HashMap;

public class VehicleService {

    private final HashMap<String, Vehicle> vehicleList = new HashMap<>();
    public void displayVehicleDetails(Vehicle vehicle) {
        if (vehicle != null) {
            System.out.println(vehicle);
        } else {
            System.out.println("Vehicle details are not available.");
        }
    }
    public Vehicle createNewVehicle() {
        Vehicle vehicle = new Vehicle();
        VehicleStatus vehicleStatus = VehicleStatus.AVAILABLE;
        try {
            vehicleStatus = VehicleStatus.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid vehicle status! Setting default to AVAILABLE.");
        }
        vehicle.setVehicleId(vehicleId);
        vehicle.setModel(vehicleModel);
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setColor(vehicleColor);
        vehicle.setAvailable(availability);
        vehicle.setSeatCapacity(seatCapacity);
        vehicle.setPerKmRate(perKmRate);
        vehicle.setVehicleStatus(vehicleStatus);  // Set vehicle status
        vehicleList.put(vehicle.getVehicleId(), vehicle);
        return vehicle;
    }
    public void showAllVehicles() {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }
        for (Vehicle vehicle : vehicleList.values()) {
            System.out.println("Vehicle Information: " + vehicle);
        }
    }
    public HashMap<String, Vehicle> getVehicleList() {
        return vehicleList;
    }
}
