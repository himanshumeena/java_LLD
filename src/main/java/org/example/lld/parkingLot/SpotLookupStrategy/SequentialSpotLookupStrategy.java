package org.example.lld.parkingLot.SpotLookupStrategy;

import org.example.lld.parkingLot.parking.*;

import java.util.*;

public class SequentialSpotLookupStrategy implements SpotLookupStrategy {
    @Override
    public ParkingSpot findAvailableParkingSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot : parkingSpots){
            if(!parkingSpot.isOccupied()){
                return parkingSpot;
            }
        }
        return null;
    }
}
