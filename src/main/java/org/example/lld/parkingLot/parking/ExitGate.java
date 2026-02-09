package org.example.lld.parkingLot.parking;

import org.example.lld.parkingLot.Ticket.*;
import org.example.lld.parkingLot.billing.*;
import org.example.lld.parkingLot.invoice.*;

import java.time.*;
import java.util.*;

public class ExitGate {
    private BillingStrategy billingStrategy;

    public ExitGate() {
        this.billingStrategy = new HourlyBillingStrategy(1);
    }

    public Optional<Invoice> exit(ParkingBuilding parkingBuilding, Ticket ticket) {
        // compute time
        long time = Duration.between(ticket.getIssuedAt(), Instant.now()).getSeconds();
        long amount = billingStrategy.getCost(time);
        System.out.println("amount: " + amount);

        parkingBuilding.unpark(ticket);
        return Optional.of(new Invoice(ticket, amount));
    }
}
