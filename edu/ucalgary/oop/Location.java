package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>();
    private ArrayList<Supply> supplies = new ArrayList<>();

    public Location(String name, String address){
        this.name = name;
        this.address = address;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setOccupants(ArrayList<DisasterVictim> occupants){
        this.occupants = occupants;
    }

    public void setSupplies(ArrayList<Supply> supplies){
        this.supplies = supplies;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public ArrayList<DisasterVictim> getOccupants(){
        return this.occupants;
    }

    public ArrayList<Supply> getSupplies(){
        return this.supplies;
    }

    public void removeOccupant(DisasterVictim occupant){
        occupants.remove(occupant);
    }

    public void addOccupant(DisasterVictim occupant){
        occupants.add(occupant);
    }

    public void addSupply(Supply supply){
        supplies.add(supply);
    }

    public void removeSupply(Supply supply){
        supplies.remove(supply);
    }


}