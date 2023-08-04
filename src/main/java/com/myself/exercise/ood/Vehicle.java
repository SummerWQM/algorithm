package com.myself.exercise.ood;

public abstract class Vehicle {


    protected String plateNo;

    protected String name;

    private final VehicleTypeEnum vehicleType;

    public Vehicle(VehicleTypeEnum vehicleType) {
        this.vehicleType = vehicleType;
    }


}
