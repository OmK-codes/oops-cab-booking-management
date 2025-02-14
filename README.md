# Cab-booking-management.

## **Project Overview**
The Core Java  Cab Booking Management Project is a straightforward Java application that demonstrates a
cab booking management system. It uses object-oriented programming principles to model the interactions between passengers, drivers, vehicles, and bookings.

## **Features**
- **Manage bookings for passengers and drivers.**
- **Assign drivers automatically based on proximity and availability.**
- **Track ride status and payment processing.**
- **Simple, intuitive structure to demonstrate key Java concepts.**

## **Installation and Setup**
- Prerequisites
- Java Development Kit (JDK) 21.
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- Git (optional, for version control).

## **Steps**
- Clone the repository:
- hashmap-cab-booking-management 
- Navigate to the project directory:
- cd hashmap-cab-booking-management.
- Open the project in your preferred IDE.
- Compile and run the application:
- Locate CabBookingManagement.java
- Run the file to start the application.

## **Code Structure**  
## **Packages Structure**
- package com.omkcodes.cab_booking.model : Contains the model classes
  - Booking.java
  - Driver.java
  - Passenger.java
  - Vehicle.java
- package com.omkcodes.cab_booking.service : Contains the Service classes
  - BookingService.java
  - DriverService.java
  - PassengerService.java
  - Vehicle-Service.java
- package com.omkcodes.cab_booking.enums : Contains the Enum classes
  - BookingStatus.java
  - DriverStatus.java
  - PassengerStatus.java
  - VehicleStatus.java
- package com.omkcodes.cab_booking.Controller : Contains the Controller classes
  - BookingController.java
  - DriverController.java
  - PassengerController.java
  - VehicleController.java
- package com.omkcodes.cab_booking.Exception : Contains the Exception Handling classes
  - CabBookingException.java
  - InvalidBookinglDException.java
  - Invalid Driverl DException.java
  - InvalidPassengerlDException.java
  - InvalidVehiclelDException.java
- package com.omkcodes.project: contains main application logic
    - CabBookingManagement.java
