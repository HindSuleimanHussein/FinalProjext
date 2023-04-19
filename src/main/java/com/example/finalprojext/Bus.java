package com.example.finalprojext;

public class Bus extends Vehicle{
    private int wheels;
    private double capacity;

    public Bus(int noOfavailableVehicle, String vehicleType, String vehicleName, String vehiclePlate, int wheels, double capacity) {
        super(noOfavailableVehicle, vehicleType, vehicleName, vehiclePlate);
        this.wheels=wheels;
        this.capacity=capacity;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }


    @Override
    public void minusFromAmount() {
        noOfavailableVehicle--;

    }

    @Override
    public void addFromAmount() {
        noOfavailableVehicle++;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getVehicleName().compareTo(o.getVehicleName());
    }
}
