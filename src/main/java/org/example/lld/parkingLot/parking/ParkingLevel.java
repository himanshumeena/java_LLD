package org.example.lld.parkingLot.parking;

import org.example.lld.parkingLot.*;
import org.example.lld.parkingLot.levelManager.*;

import java.util.*;

public class ParkingLevel {
    private String levelName;
    private Map<VehicleType, ParkingLevelManager> parkingLevelManager;

    public ParkingLevel(String levelName){
        this.levelName = levelName;
        this.parkingLevelManager = new HashMap<>();
    }

    public void addManager(VehicleType vehicleType, ParkingLevelManager manager){
        parkingLevelManager.put(vehicleType, manager);
    }

    public ParkingSpot getFreeParkingSpot(Vehicle vehicle){
        ParkingLevelManager manager = parkingLevelManager.get(vehicle.getVehicleType());
        return manager.getFreeParkingSpot();
    }

    public ParkingLevelManager getManager(VehicleType vehicleType){
        return parkingLevelManager.get(vehicleType);
    }

    @Override
    public String toString() {
        return "ParkingLevel{" +
                "levelName='" + levelName + '\'' +
                ", parkingLevelManager=" + parkingLevelManager +
                '}';
    }
}
