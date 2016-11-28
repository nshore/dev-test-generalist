package com.bikeapp.domain;

//Redundant Class
//Planned to use Class to handle Bike objects and get and set values
public class Bike {

    private final int bikeId;
    private final String bikeName;
    private final String bikeDescription;
    private final String bikePrice;

    public Bike(int bikeId, String bikeName, String bikeDescription, String bikePrice) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
        this.bikeDescription = bikeDescription;
        this.bikePrice = bikePrice;
    }

    public int getBikeId() {
        return bikeId;
    }
    public String getBikeName() { return bikeName; }
    public String getBikeDescription() { return bikeDescription; }
    public String getBikePrice() { return bikePrice; }
}
