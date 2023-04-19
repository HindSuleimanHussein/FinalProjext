package com.example.finalprojext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface VehicleRentInt {
    void addCustomer(String name, String address, String plan) throws FileNotFoundException;
    void deleteCustomer(String name) throws IOException;
    int searchCustomers(String name);
    void addCar(String name, String type,int noOfCarAvailable,String rating, int numberofpassengers, String vehiclePlate) throws FileNotFoundException;
    void addTruck(String name,String type,double weight,double load, int noOfavailableTruck, String vehiclePlate) throws FileNotFoundException;
    void addBus(String name, String type ,int noOfavailableBus, int wheels, double capacity,  String vehiclePlate) throws FileNotFoundException;
    void setLimitedPlanLimit(int value);
    String getAllCustomersInfo();
    String getAllVehicleInfo();
    boolean addToCart(String customerName,String vehicle_name) throws FileNotFoundException;
    boolean removeFromCart(String customerName, String vehicleName ) throws FileNotFoundException;
    String processRequests() throws IOException;
    boolean returnVehicle(String customerName,String vehicleName) throws IOException;
    ArrayList<String> searchVehicle(String name, String type, String rating);


}
