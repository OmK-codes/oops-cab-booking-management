package com.omkcodes.cab_booking.service;

import com.omkcodes.cab_booking.enums.DriverStatus;
import com.omkcodes.cab_booking.model.Driver;

import java.util.HashMap;

public class DriverService {

    private final HashMap<String, Driver> driverList = new HashMap<>();
    public void displayDriverDetails(Driver driver) {
        if (driver != null) {
            System.out.println(driver);
        } else {
            System.out.println("Driver details are not available.");
        }
    }
    public Driver createNewDriver() {
        Driver driver = new Driver();
        DriverStatus driverStatus = DriverStatus.INACTIVE;
        try {
            driverStatus = DriverStatus.valueOf(statusInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid driver status! Setting default to INACTIVE.");
        }
        driver.setDriverId(driverId);
        driver.setDriverName(driverName);
        driver.setPhone(phone);
        driver.setLicenseNumber(licenseNumber);
        driver.setTotalTrips(totalTrips);
        driver.setOnlineStatus(onlineStatus);
        driver.setDriverStatus(driverStatus);
        driverList.put(driver.getDriverId(), driver);

        return driver;
    }
    public void showAllDrivers() {
        if (driverList.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }
        for (Driver driver : driverList.values()) {
            System.out.println("Driver Information: " + driver);
        }
    }
    public HashMap<String, Driver> getDriverList() {
        return driverList;
    }
}
