package org.example.lld.parkingLot.billing;

public class HourlyBillingStrategy  implements BillingStrategy {
    long perHourCost;

    public HourlyBillingStrategy(long perHourCost) {
        this.perHourCost = perHourCost;
    }

    @Override
    public long getCost(long duration){
        return duration * perHourCost;
    }
}
