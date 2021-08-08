package demo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
    public static void main(String[] args) {
        try{

            iCar car = new iCarImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CarService", car);

            System.out.println("CarService bound in registry");
            System.out.println("CarService is running");

        }catch(Exception e){

            System.err.println("Problem: " + e);
            System.exit(1);

        }

    }
}
