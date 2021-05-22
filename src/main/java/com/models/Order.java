package com.models;

import com.myJDBC.DAO;

public class Order {

    private String name;
    private String address;
    private int sum;
    private DAO.State state;

    public Order(String name, String address, int sum, DAO.State state) {
        this.name = name;
        this.address = address;
        this.sum = sum;
        this.state = state;
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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public DAO.State getState() {
        return state;
    }

    public void setState(DAO.State state) {
        this.state = state;
    }
}
