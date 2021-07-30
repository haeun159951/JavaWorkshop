package ws09;

import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private String color;
    private double mileage;
    private String registration;

    public Car(String model, String color, double mileage, String registration) {
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.registration = "unregistered";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void getRegistered(String plate) {
       registration = plate;
    }

    public void setPlate(String plate) {
        registration = plate;
    }

    @Override
    public String toString() {
        return "Model: " + model + " Colour: " + color +
                " mileage: " +  mileage +
                " Plate: " + registration;
    }
}
