package org.example.lld.parkingLot;

import org.example.lld.parkingLot.SpotLookupStrategy.*;
import org.example.lld.parkingLot.Ticket.*;
import org.example.lld.parkingLot.invoice.*;
import org.example.lld.parkingLot.levelManager.*;
import org.example.lld.parkingLot.parking.*;

import java.util.*;

public class ParkingLotRunner {
    public static void runme() throws InterruptedException {
        // ParkingSpot
        ParkingSpot spot_1 = new ParkingSpot("spot_1", VehicleType.TWO_WHEELER, false);
        ParkingSpot spot_2 = new ParkingSpot("spot_2", VehicleType.FOUR_WHEELER, false);

        ParkingSpot spot_3 = new ParkingSpot("spot_3", VehicleType.TWO_WHEELER, false);
        ParkingSpot spot_4 = new ParkingSpot("spot_4", VehicleType.FOUR_WHEELER, false);

        // ParkingLevelManager
        ParkingLevelManager levelOne_TwoWheelerParkingLevelManager = new TwoWheelerParkingLevelManager(List.of(spot_1), new SequentialSpotLookupStrategy());
        ParkingLevelManager levelOne_FourWheelerParkingLevelManager = new FourWheelerParkingLevelManager(List.of(spot_2), new SequentialSpotLookupStrategy());

        ParkingLevelManager levelTwo_TwoWheelerParkingLevelManager = new TwoWheelerParkingLevelManager(List.of(spot_3), new SequentialSpotLookupStrategy());
        ParkingLevelManager levelTwo_FourWheelerParkingLevelManager = new FourWheelerParkingLevelManager(List.of(spot_4), new SequentialSpotLookupStrategy());

        // ParkingLevel
        ParkingLevel parkingLevel1 = new ParkingLevel("Level_1");
        ParkingLevel parkingLevel2 = new ParkingLevel("Level_2");

        // associate managers with levels
        parkingLevel1.addManager(VehicleType.TWO_WHEELER, levelOne_TwoWheelerParkingLevelManager);
        parkingLevel1.addManager(VehicleType.FOUR_WHEELER, levelOne_FourWheelerParkingLevelManager);

        parkingLevel2.addManager(VehicleType.TWO_WHEELER, levelTwo_TwoWheelerParkingLevelManager);
        parkingLevel2.addManager(VehicleType.FOUR_WHEELER, levelTwo_FourWheelerParkingLevelManager);

        // Building
        ParkingBuilding parkingBuilding = new ParkingBuilding();
        parkingBuilding.addLevel(parkingLevel1);
        parkingBuilding.addLevel(parkingLevel2);

        // Gates
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();

        // ParkingLot
        ParkingLot parkingLot = new ParkingLot(parkingBuilding, entryGate, exitGate);
        // Vehicles

        Vehicle twoWheeler_1 = new TwoWheelerVehicle("scooty_1");
        Vehicle twoWheeler_2 = new TwoWheelerVehicle("scooty_2");

        Vehicle fourWheeler_1 = new TwoWheelerVehicle("fourWheeler_1");
        Vehicle fourWheeler_2 = new TwoWheelerVehicle("fourWheeler_2");

        // enter twoWheeler_1
        Ticket ticket = parkingLot.vehicleArrive(twoWheeler_1).orElseThrow(()->{
            System.out.println("Parking full");
            return new RuntimeException("Parking full");
        });

        System.out.println(ticket);

        // exit twoWheeler_1
        Thread.sleep(4000);
        Invoice invoice = parkingLot.vehicleExit(ticket).orElseThrow(()->{
            System.out.println("Invoice error");
            return new RuntimeException("Invoince error");
        });

        System.out.println("Invoice : " + invoice);
    }

}

