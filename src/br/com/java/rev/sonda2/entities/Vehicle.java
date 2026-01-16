package br.com.java.rev.sonda2.entities;

public class Vehicle {

    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public Vehicle() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                '}';
    }
}
