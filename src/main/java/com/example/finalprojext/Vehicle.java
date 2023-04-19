package com.example.finalprojext;

public abstract class Vehicle implements Comparable<Vehicle>{

    int noOfavailableVehicle;
    private String vehicleType;
    private String vehicleName;
    private String vehiclePlate;

    public Vehicle(int noOfavailableVehicle, String vehicleType, String vehicleName, String vehiclePlate) {
        this.noOfavailableVehicle = noOfavailableVehicle;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.vehiclePlate=vehiclePlate;
    }

    public int getNoOfavailableVehicle() {
        return noOfavailableVehicle;
    }

    public void setNoOfavailableVehicle(int noOfavailableVehicle) {
        this.noOfavailableVehicle = noOfavailableVehicle;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public abstract void minusFromAmount();
    public abstract void addFromAmount();
}
