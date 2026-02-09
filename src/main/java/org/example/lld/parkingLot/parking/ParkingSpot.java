package org.example.lld.parkingLot.parking;

import org.example.lld.parkingLot.*;

public class ParkingSpot {
    private String id;
    private VehicleType type;
    private boolean isOccupied;

    public ParkingSpot(String id, VehicleType type, boolean occupied) {
        this.id = id;
        this.type = type;
        this.isOccupied = occupied;
    }

    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
