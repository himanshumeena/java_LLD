package org.example.lld.parkingLot.parking;

import org.example.lld.parkingLot.*;
import org.example.lld.parkingLot.Ticket.*;

import java.util.*;

public class EntryGate {
    public EntryGate() {}

    public Optional<Ticket> enter(ParkingBuilding parkingBuilding, Vehicle vehicle) {
        return parkingBuilding.park(vehicle);
    }
}
