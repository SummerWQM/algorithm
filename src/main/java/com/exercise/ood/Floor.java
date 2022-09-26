package com.exercise.ood;

import java.util.List;

public class Floor {

    private List<ParkingSpot> spotList;

    private int availableCount;

    private boolean available;

    public Floor() {
        this.availableCount = Constants.NUM_SPOTS;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void updateAvailableCount() {

    }


}
