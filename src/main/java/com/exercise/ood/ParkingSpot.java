package com.exercise.ood;

/**
 * 停车位
 */
public class ParkingSpot {

    // 停车位大小
    private ParkingSpotTypeEnum type;
    // 停车位是否可用
    private boolean available;
    // 停的车子
    private Vehicle vehicle;
    //车位号
    private int spotNo;
    //楼层
    private Floor floor;

    public ParkingSpot(ParkingSpotTypeEnum type) {

        this.type = type;
    }


    public boolean isAvailable() {
        return available;
    }

    public boolean canVehicleFit(Vehicle vehicle) {
        return true;
    }

    public void takeSpot(Vehicle vehicle) {
        available = false;
    }

    public void leaveSpot(Vehicle vehicle) {
        available = true;
    }


}
