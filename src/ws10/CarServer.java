package ws10;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer {
    //public CalculatorServer() throws RemoteException{}
    public CarServer() throws RemoteException {
        try {
            CarInterface car = new CarImplementation();
            Registry registry = LocateRegistry.getRegistry(8080);
            Naming.rebind("rmi://localhost:8080/CarService", car);
        }catch(Exception e) {
            System.out.println("Trouble: "+e.getMessage());
        }
    }
    public static void main(String[] args) throws RemoteException{
        new CarServer();
    }
}