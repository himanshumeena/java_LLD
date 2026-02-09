package org.example.lld.parkingLot.levelManager;

import org.example.lld.parkingLot.SpotLookupStrategy.*;
import org.example.lld.parkingLot.parking.*;

import java.util.List;

public class TwoWheelerParkingLevelManager extends ParkingLevelManager {
    public TwoWheelerParkingLevelManager(List<ParkingSpot> parkingSpots, SpotLookupStrategy lookupStrategy) {
        super(parkingSpots, lookupStrategy);
    }
}
