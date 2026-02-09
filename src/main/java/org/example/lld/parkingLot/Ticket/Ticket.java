package org.example.lld.parkingLot.Ticket;

import org.example.lld.parkingLot.*;
import org.example.lld.parkingLot.parking.*;

import java.time.*;

public class Ticket {
    private Instant issuedAt;
    private Vehicle vehicle;
    private ParkingLevel parkingLevel;
    private ParkingSpot parkingSpot;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot parkingSpot) {
        this.issuedAt = Instant.now();
        this.vehicle = vehicle;
        this.parkingLevel = parkingLevel;
        this.parkingSpot = parkingSpot;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "issuedAt=" + issuedAt +
                ", vehicle=" + vehicle +
                ", parkingLevel=" + parkingLevel +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
