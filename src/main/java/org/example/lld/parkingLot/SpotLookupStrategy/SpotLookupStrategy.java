package org.example.lld.parkingLot.SpotLookupStrategy;

import org.example.lld.parkingLot.parking.*;

import java.util.*;

public interface SpotLookupStrategy {
    public ParkingSpot findAvailableParkingSpot(List<ParkingSpot> parkingSpots);
}
