package com.example.finalprojext;

public class Car extends Vehicle{
    private int passengers;
    private String rating;


    public Car(int noOfavailableVehicle, String vehicleType, String vehicleName, String vehiclePlate, int passengers, String rating) {
        super(noOfavailableVehicle, vehicleType, vehicleName, vehiclePlate);
        this.passengers=passengers;
        this.rating = rating;
    }


    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Car{" + "No. of Available Vehicle: " + getNoOfavailableVehicle() +
                " Type: " + getVehicleType() +
                " Name: " + getVehicleName() +
                " Vehicle Plate: " + getVehiclePlate() +
                " passengers= " + passengers +
                ", rating='" + rating + '\'' +
                '}';
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getVehicleName().compareTo(o.getVehicleName());
    }

    @Override
    public void minusFromAmount() {
        noOfavailableVehicle--;

    }

    @Override
    public void addFromAmount() {
        noOfavailableVehicle++;
    }
}
