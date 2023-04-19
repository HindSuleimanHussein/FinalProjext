package com.example.finalprojext;

public class Truck extends Vehicle {
    private double weight;
    private double load;

    public Truck(int noOfavailableVehicle, String vehicleType, String vehicleName, String vehiclePlate, double weight, double load) {
        super(noOfavailableVehicle, vehicleType, vehicleName, vehiclePlate);
        this.weight=weight;
        this.load=load;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
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
