package com.example.finalprojext;
import java.util.*;

public class Customer implements Comparable<Customer>{
    private String name;
    private String address;
    private String plan;
    ArrayList<String> interested;
    ArrayList<String> received;

    public Customer(String name, String address, String plan) {
        this.name = name;
        this.address = address;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public ArrayList<String> getInterested() {
        return interested;
    }

    public void setInterested(ArrayList<String> interested) {
        this.interested = interested;
    }

    public ArrayList<String> getReceived() {
        return received;
    }

    public void setReceived(ArrayList<String> received) {
        this.received = received;
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(this.name, ((Customer) o).name);
    }



    public String Interested() {
        StringBuilder st = new StringBuilder();
        st.append(name);
        st.append(" ");
        for (int i = 0; i < interested.size() - 1; i++) {
            st.append(interested.get(i + 1));
            st.append(" ");
        }
        return st.toString();
    }

    public String Received() {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<received.size();i++) {
            str.append(received.get(i));
            str.append(" ");
        }
        return str.toString();
    }

    public void haveBeenReceived(int i) {
        received.add(interested.get(i));
    }

    public void addInterested(String vehicle) {
        interested.add(vehicle);
    }
    public void addReceived(String vehicle) {
        received.add(vehicle);
    }


    @Override
    public String toString() {
        return "Customer{" + "name: '" + name + ", address: '" + address + ", plan: '" + plan  + '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }
}
