package org.example.lld.parkingLot.billing;

public interface BillingStrategy {
    long getCost(long duration);
}
