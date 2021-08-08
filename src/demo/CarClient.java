package demo;

import java.rmi.Naming;

public class CarClient {

    public static void main(String[] args) {
        try{

            iCar connect = (iCar)Naming.lookup("rmi://localhost:1099/CarService");
            Car car = new Car("Lexus CT200H","White",213.7);
            car.setPlate(connect.plateNum(car));
            System.out.println(car);

        }catch(Exception e){
            System.err.println("Problem: " + e);
            System.exit(1);
        }
    }
}
