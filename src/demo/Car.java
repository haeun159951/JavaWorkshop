package demo;

import java.io.Serializable;

public class Car implements Serializable {
    private final String model;
    private final String colour;
    private final double mileage;
    private String plate;

    public Car(String model, String color, double mileage) {
        this.model = model;
        this.colour = color;
        this.mileage = mileage;
        this.plate = "undefined";
    }

    public void setPlate(String plate) { this.plate = plate;}

    @Override
    public String toString() {
        return "Car Model: " + model + "\n" + "Colour: " +
                colour + "\n" + "Mileage: " + mileage + "\n" + "Plate: " + plate + "\n";
    }
}
