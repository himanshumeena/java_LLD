package org.example.lld.parkingLot.parking;

import org.example.lld.parkingLot.*;
import org.example.lld.parkingLot.Ticket.*;
import org.example.lld.parkingLot.invoice.*;

import java.util.*;

public class ParkingLot {
    private ParkingBuilding parkingBuilding;
    private EntryGate entryGate;
    private ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntryGate entryGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Optional<Ticket> vehicleArrive(Vehicle vehicle) {
        System.out.println("Vehicle arrived: ");
        return entryGate.enter(parkingBuilding, vehicle);
    }

    public Optional<Invoice> vehicleExit(Ticket ticket) {
        System.out.println("Vehicle exiting: ");
        return exitGate.exit(parkingBuilding, ticket);
    }
}
