package com.exercise.ood;

import java.util.List;

public class ParkingLot {

    private String name;

    private boolean available;

    private List<Floor> floorList;

    public boolean isAvailable() {
        return available;
    }


    public void enter(Vehicle vehicle) {


        // ticket -> in time.

        //
    }

    public Floor findFloorAvailable() {
        return null;
    }

    public int getAvailableCount() {
        return 1;
    }

    public boolean canVehicle(Vehicle vehicle) {
        return true;
    }

    public Ticket exit(Vehicle vehicle) {

        return null;
    }

    public float calculate(Ticket ticket) {
        return 0;
    }

}
