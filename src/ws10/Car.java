package ws10;

import java.io.Serializable;

public class Car implements Serializable {

    private String model;
    private String color;
    private double mileage;
    private String plate;

    public Car(String model, String color, double mileage) {
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.plate = "unregistered";
    }


    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Model: " + model + " Colour: " + color +
                " mileage: " +  mileage +
                " Plate: " + plate;
    }
}
