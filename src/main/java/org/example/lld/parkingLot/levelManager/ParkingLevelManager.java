package org.example.lld.parkingLot.levelManager;

import java.util.ArrayList;
import java.util.List;

import org.example.lld.parkingLot.SpotLookupStrategy.SpotLookupStrategy;
import org.example.lld.parkingLot.parking.ParkingSpot;

public abstract class ParkingLevelManager {
    public List<ParkingSpot> parkingSpots;
    private SpotLookupStrategy lookupStrategy;

    public ParkingLevelManager(List<ParkingSpot> parkingSpots, SpotLookupStrategy lookupStrategy) {
        this.parkingSpots = new ArrayList<>(parkingSpots);
        this.lookupStrategy = lookupStrategy;
    }

    public void addSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public ParkingSpot getFreeParkingSpot() {
        ParkingSpot spot = lookupStrategy.findAvailableParkingSpot(parkingSpots);
        return spot != null ? spot : null;
    }

    public boolean updateParkingSpot(String spotId, boolean isOccupied) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getId().equals(spotId)) {
                spot.setOccupied(isOccupied);
                ;
                return true;
            }
        }
        return false;
    }

}
