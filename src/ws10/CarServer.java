package ws10;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {

    public CarServer() {
        try {
            CarInterface car = new CarImplementation();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CarService", car);
            System.out.println("Car Service bound in registry");
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) throws RemoteException {
        new CarServer();
        System.out.println("Car service is running");
    }
}