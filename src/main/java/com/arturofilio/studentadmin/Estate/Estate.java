package com.arturofilio.studentadmin.Estate;

import java.util.UUID;

public class Estate {
    private final UUID estateId;

    public Estate(UUID estateId, String address, EstateType type, int squaredFeet, boolean rented) {
        this.estateId = estateId;
        this.address = address;
        this.type = type;
        this.squaredFeet = squaredFeet;
        this.rented = rented;
    }

    private final String address;
    private final EstateType type;
    private final int squaredFeet;
    private boolean rented;

    public enum EstateType {
        Appartment, House, TownHouse
    }


    public UUID getEstateId() {
        return this.estateId;
    }


    public String getAddress() {
        return this.address;
    }


    public EstateType getType() {
        return this.type;
    }


    public int getSquaredFeet() {
        return this.squaredFeet;
    }


    public boolean isRented() {
        return this.rented;
    }

    public boolean getRented() {
        return this.rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

}
