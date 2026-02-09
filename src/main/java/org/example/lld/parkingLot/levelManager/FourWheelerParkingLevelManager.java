package org.example.lld.parkingLot.levelManager;

import org.example.lld.parkingLot.SpotLookupStrategy.*;
import org.example.lld.parkingLot.parking.*;

import java.util.*;

public class FourWheelerParkingLevelManager extends ParkingLevelManager {
    public FourWheelerParkingLevelManager(List<ParkingSpot> parkingSpots, SpotLookupStrategy lookupStrategy){
        super(parkingSpots, lookupStrategy);
    }
}
