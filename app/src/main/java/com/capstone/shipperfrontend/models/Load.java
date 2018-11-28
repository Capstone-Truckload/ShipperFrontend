package com.capstone.shipperfrontend.models;

import java.io.Serializable;

public class Load implements Serializable {
    public final String destination;
    public final double distance;
    public final String owner;

    public Load(String dest, double dist, String own) {
        destination = dest;
        distance = dist;
        owner = own;
    }
}
