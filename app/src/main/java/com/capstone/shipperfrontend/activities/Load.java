package com.capstone.shipperfrontend.activities;

import java.util.UUID;

public class Load {
    String name;
    String id;
    String origin;
    String destination;
    String price;


    public Load(String name, String id, String origin, String destination, String price) {
        this.name = name;
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    //copy constructor
    public Load(Load that) {
        this.name = that.name;
        this.id = that.id;
        this.origin = that.origin;
        this.destination = that.destination;
        this.price = that.price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
