package org.example.lld.parkingLot.parking;

import org.example.lld.parkingLot.*;
import org.example.lld.parkingLot.Ticket.*;
import org.example.lld.parkingLot.levelManager.*;

import java.util.*;

public class ParkingBuilding {
    private List<ParkingLevel> parkingLevels;

    public ParkingBuilding() {
        this.parkingLevels = new ArrayList<>();
    }

    public void addLevel(ParkingLevel parkingLevel) {
        this.parkingLevels.add(parkingLevel);
    }

    public void addLevel(ParkingLevel... parkingLevels) {
        this.parkingLevels.addAll(List.of(parkingLevels));
    }

    public Optional<Ticket> park(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : parkingLevels) {
            ParkingSpot freeParkingSpot = parkingLevel.getFreeParkingSpot(vehicle);
            if (freeParkingSpot != null) {
                freeParkingSpot.setOccupied(true);
                return Optional.of(new Ticket(vehicle, parkingLevel, freeParkingSpot));
            }
        }
        return Optional.empty();
    }

    public void unpark(Ticket ticket) {
        ParkingSpot spot = ticket.getParkingSpot();
        ParkingLevel parkingLevel = ticket.getParkingLevel();

        ParkingLevelManager manager =  parkingLevel.getManager(ticket.getVehicle().getVehicleType());
        manager.updateParkingSpot(spot.getId(),false);
    }
}
