package org.example.lld.parkingLot.billing;

public class FixedCostBillingStrategy implements BillingStrategy {
    long fixedCost;

    FixedCostBillingStrategy(long fixedCost) {
        this.fixedCost = fixedCost;
    }

    @Override
    public long getCost(long duration) {
        return 100;
    }
}
