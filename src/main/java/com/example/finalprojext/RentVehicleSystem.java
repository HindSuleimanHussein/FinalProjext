package com.example.finalprojext;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RentVehicleSystem implements VehicleRentInt{
        File customer = new File("addCustomer.txt");
        File addCarFile = new File("addCar.txt");
        File addTruckFile = new File("addTruck.txt");
        File addBusFile = new File("addBus.txt");
        File interested = new File("interested.txt");
        File received = new File("received.txt");
        ArrayList<Customer> customerArray=new ArrayList<>();
        ArrayList<Car> carArray = new ArrayList<>();
        ArrayList<Truck> truckArray = new ArrayList<>();
        ArrayList<Bus> busArray = new ArrayList<>();
        ArrayList<Vehicle> vehicleArray = new ArrayList<>();
        int limitedPlan=2;

    public RentVehicleSystem() throws IOException{
        super();
        //mergeTheFiles();

    }

    private void mergeTheFiles() throws IOException{
        readCarFile();
        readTruckFile();
        readBusFile();
        vehicleArray.addAll(carArray);
        vehicleArray.addAll(truckArray);
        vehicleArray.addAll(busArray);
    }

    private void readCarFile() throws IOException{
        Scanner input = new Scanner(addCarFile);
        while(input.hasNext()){
            carArray.add(new Car(input.nextInt(), input.next(), input.next(), input.next(), input.nextInt(), input.next()));
        }
        input.close();
    }

    private void readTruckFile() throws IOException{
        Scanner input = new Scanner(addTruckFile);
        while(input.hasNext()){
            truckArray.add(new Truck (input.nextInt(), input.next(), input.next(), input.next(), input.nextDouble(), input.nextDouble()));
        }
        input.close();
    }

    private void readBusFile() throws IOException{
        Scanner input = new Scanner(addBusFile);
        while(input.hasNext()){
            busArray.add(new Bus(input.nextInt(), input.next(), input.next(), input.next(), input.nextInt(), input.nextDouble()));

        }
        input.close();
    }

    private void readFileRented() throws IOException{
        readFileCustomer();
        Scanner input = new Scanner(interested);
        for (int i=0; i<customerArray.size() && input.hasNext(); i++){
            String words = input.nextLine();
            String[] forSpace = words.split(" ");
            for (int j=0; j< forSpace.length; j++) {
                customerArray.get(i).addInterested(forSpace[j]);
            }
        }
        input.close();

    }

    public void readFileReceived( ) throws IOException{
        readFileRented();
        Scanner input = new Scanner(received);
        for (int i=0; i<customerArray.size() && input.hasNext(); i++){
            String words = input.nextLine();
            String[] forSpace = words.split(" ");
            for (int j=0; j<forSpace.length; j++) { // this was just the enhanced version of for(int j=0; j<forSpace.length; j++)
                customerArray.get(i).addReceived(forSpace[j]);
            }
        }
        input.close();

    }
    private void readFileCustomer() throws IOException {
        Scanner input = new Scanner(customer);
        while(input.hasNext()){
            customerArray.add(new Customer( input.next(), input.next(), input.next()));
        }
        input.close();
    }

    @Override
    public void addCustomer(String name, String address, String plan) throws FileNotFoundException {
        customerArray.add(new Customer(name, address, plan));
        Collections.sort(customerArray);
        PrintWriter customerWriter = new PrintWriter(customer);
        for(int i=0; i<customerArray.size(); i++){
                customerWriter.println(customerArray.get(i).toString());

            }
        customerWriter.flush();
        customerWriter.close();


    }
    @Override
    public void deleteCustomer(String name) throws IOException {

        int x=searchCustomers(name);
        customerArray.remove(x);
        PrintWriter customerWriter = new PrintWriter(customer);
        for(int i=0; i<customerArray.size(); i++){
            customerWriter.println(customerArray.get(i).toString());
            customerWriter.flush();
        }
        customerWriter.close();

    }

    @Override
    public int searchCustomers(String name){
        for(int i=0; i<customerArray.size(); i++){
            if(customerArray.get(i).getName().equals(name)){
                System.out.println(customerArray.get(i));
                return i;
            }
        }

        return -1;

    }

    @Override
    public void addCar(String name, String type,int noOfCarAvailable,String rating, int numberofpassengers, String vehiclePlate) throws FileNotFoundException{
        carArray.add(new Car(noOfCarAvailable, type, name, vehiclePlate, numberofpassengers, rating));
        PrintWriter carWriter = new PrintWriter(addCarFile);
        for (int i = 0; i < carArray.size(); i++) {
            System.out.println(carArray);
            carWriter.println(carArray.get(i).toString());

            carWriter.flush();
            carWriter.close();
            }

        }


    @Override
    public void addTruck(String name, String type, double weight, double load, int noOfavailableTruck, String vehiclePlate) throws FileNotFoundException {
        truckArray.add(new Truck(noOfavailableTruck, type, name, vehiclePlate, weight, load));
        PrintWriter truckWriter = new PrintWriter(addTruckFile);
        for (int i = 0; i < truckArray.size(); i++) {
            System.out.println(truckArray);
            truckWriter.println(truckArray.get(i).toString());

            truckWriter.flush();
            truckWriter.close();
        }

    }

    @Override
    public void addBus(String name, String type, int noOfavailableBus, int wheels, double capacity,  String vehiclePlate) throws FileNotFoundException {
        busArray.add(new Bus(noOfavailableBus, type, name, vehiclePlate, wheels, capacity));
        PrintWriter busWriter = new PrintWriter(addBusFile);
        for (int i = 0; i < busArray.size(); i++) {
            System.out.println(busArray);
            busWriter.println(busArray.get(i).toString());

            busWriter.flush();
            busWriter.close();
        }

    }

    @Override
    public void setLimitedPlanLimit(int value) {
        limitedPlan= value;

    }

    @Override
    public String getAllCustomersInfo() {
        StringBuilder allCustomersInfo = new StringBuilder();
        for(int i=0;i<customerArray.size();i++) {
            allCustomersInfo.append(customerArray.get(i).toString());

        }
        return allCustomersInfo.toString();
    }

    @Override
    public String getAllVehicleInfo() {
        Collections.sort(vehicleArray);
        StringBuilder allVehicleInfo = new StringBuilder();
        for(int i=0;i<vehicleArray.size();i++) {
            allVehicleInfo.append(vehicleArray.get(i).toString());

        }
        return allVehicleInfo.toString();
    }

    @Override
    public boolean addToCart(String customerName, String vehicle_name) throws FileNotFoundException {
        ArrayList<String> customer = new ArrayList<>();
        boolean check = true;
        int positionofCustomer= 0;
        for (int i = 0; i < customerArray.size(); i++) {
            if (customerArray.get(i).getName().equalsIgnoreCase(customerName)) {
                customer = customerArray.get(i).getInterested();
                positionofCustomer= i;
                break;

            }
        }

        for(int i=0; i<customer.size(); i++){
            if(customer.get(i).equals(vehicle_name)){
                check = false;
            }
        }

        if(check){
            customer.add(vehicle_name);
            customerArray.get(positionofCustomer).interested = customer;

        }
        PrintWriter interestedWriter = new PrintWriter(interested);
        for(int i=0; i<customerArray.size(); i++){
            interestedWriter.println(customerArray.get(i).Interested());
        }

        interestedWriter.close();
        return check;
    }

    @Override
    public boolean removeFromCart(String customerName, String vehicleName) throws FileNotFoundException {
        ArrayList<String> customer = new ArrayList<>();
        boolean check = false;
        int positionofCustomer= 0;
        for (int i = 0; i < customerArray.size(); i++) {
            if (customerArray.get(i).getName().equalsIgnoreCase(customerName)) {
                customer = customerArray.get(i).getInterested();
                positionofCustomer= i;
                break;

            }
        }

        for(int i=0; i<customer.size(); i++){
            if(customer.get(i).equals(vehicleName)){
                check = true;
            }
        }

        if(check){
            customer.remove(vehicleName);
            customer = customerArray.get(positionofCustomer).getInterested();

        }
        PrintWriter interestedWriter = new PrintWriter(interested);
        for(int i=0; i<customerArray.size(); i++){
            interestedWriter.println(customerArray.get(i).getInterested());
        }

        interestedWriter.close();
        return check;
    }

    @Override
    public String processRequests() throws IOException {
        for (int i = 0; i < customerArray.size(); i++) {
            if(customerArray.get(i).getPlan().equalsIgnoreCase("Limited")) {
                for(int j=0;j<limitedPlan+1 && j<customerArray.get(i).interested.size();j++) {
                    if(copies(customerArray.get(i).interested.get(i))){
                        customerArray.get(i).haveBeenReceived(j);
                        System.out.println("Sending" + customerArray + customerArray.get(i).interested.get(j) + "to " + customerArray.get(i).getName());
                    }
                }
            }
            else if(customerArray.get(i).getPlan().equalsIgnoreCase("UnLimited")) {
                for(int j=0;j<customerArray.get(i).interested.size();j++) {
                    if(copies(customerArray.get(i).interested.get(j))) {
                        customerArray.get(i).haveBeenReceived(j);
                        System.out.println("Sending " + customerArray.get(i).interested.get(j) + " to " + customerArray.get(i).getName());
                    }
                }
            }
        }
        PrintWriter receivedWriter = new PrintWriter(received);
        for(int i=0; i<customerArray.size(); i++){
            receivedWriter.println(customerArray.get(i).Received());
        }
        receivedWriter.close();
        printTheVehicle();
        return "successful termination";
    }

    @Override
    public boolean returnVehicle(String customerName, String vehicleName) throws IOException {
        boolean check = false;
        ArrayList<String> guest = new ArrayList<>();
        int positionofCustomer=0;
        for(int i=0;i<customerArray.size();i++) {
            if(	customerArray.get(i).getName().equalsIgnoreCase(customerName)) {
                guest=customerArray.get(i).getReceived();
                positionofCustomer=i;
                break;

            }
        }

        for(int i=0;i<guest.size();i++) {
            if(	guest.get(i).equalsIgnoreCase(vehicleName)) {
                check = true;
            }
        }
        if(check){
            guest.remove(vehicleName);
            addingCopies(vehicleName);
            guest = customerArray.get(positionofCustomer).received;

        }

        PrintWriter printing = new PrintWriter(received);
        for(int i=0; i<customerArray.size(); i++){
            printing.println(customerArray.get(i).received);
        }
        printTheVehicle();
        printing.close();
        return check;

    }

    @Override
    public ArrayList<String> searchVehicle(String name, String type, String rating) {
        ArrayList<String> searchVehicleArray = new ArrayList<>();
        if (name == null && type == null && rating == null) {
            for (int i = 0; i < vehicleArray.size(); i++) {
                searchVehicleArray.add(vehicleArray.get(i).toString());
            }
            return searchVehicleArray;
        }

        else if (name != null) {
            for (int i = 0; i < vehicleArray.size(); i++) {
                if (vehicleArray.get(i).getVehicleName().equals(name)) {
                    searchVehicleArray.add(vehicleArray.get(i).toString());
                }
            }
            return searchVehicleArray;
        }
            else if(rating != null) {
                for(int i=0;i<vehicleArray.size();i++) {
                    if(((Car)carArray.get(i)).getRating().equals(rating)) {
                        searchVehicleArray.add(carArray.get(i).toString());
                    }
                }
                return searchVehicleArray;
            }


            else if(type != null) {
                for(int i=0;i<vehicleArray.size();i++) {
                    if(truckArray.get(i).getVehicleType().equals(type)) {
                        searchVehicleArray.add(truckArray.get(i).toString());
                    }
                }
                return searchVehicleArray;
            }

            else
                return searchVehicleArray;


    }


    private boolean copies(String NoOfavailableVehicle) {
        int index =1;
        for(int i=0; i<vehicleArray.size(); i++){
            if(vehicleArray.get(i).getVehicleName().equals(NoOfavailableVehicle)){
                index =i;
                break;
            }
        }
        if (vehicleArray.get(index).getNoOfavailableVehicle()>0){
            vehicleArray.get(index).minusFromAmount();
            return true;
        }
        return false;
    }

    private void addingCopies(String NoOfavailableVehicle) {

        for (int i = 0; i < vehicleArray.size(); i++) {
            if (vehicleArray.get(i).getVehicleName().equals(NoOfavailableVehicle)) {
                vehicleArray.get(i).addFromAmount();
                break;
            }
        }
    }


    private void printTheVehicle()throws IOException{
        PrintWriter carWriter  = new PrintWriter(addCarFile);
        for(int i=0;i<carArray.size();i++) {
            carWriter.println(carArray.get(i).toString());
        }
        carWriter.close();


        PrintWriter truckWriter = new PrintWriter(addTruckFile);
        for(int i=0;i<truckArray.size();i++) {
            truckWriter.println(truckArray.get(i).toString());
        }
        truckWriter.close();

        PrintWriter busWriter = new PrintWriter(addBusFile);
        for(int i=0;i<busArray.size();i++) {
            busWriter.println(busArray.get(i).toString());
        }
        busWriter.close();

    }
}



