package com.JFTtPP.models;

public class Order {

    private String name;
    private String address;
    private int sum;
    private String state;

    public Order(String name, String address, String state, int sum) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
