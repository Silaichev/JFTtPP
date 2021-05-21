package com.models;

public class Visitor {
    private int id;
    private String name;

    public Visitor(String name) {
        this.name = name;
    }

    public Visitor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
