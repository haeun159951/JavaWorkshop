package ws10;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarInterface extends Remote {
    String registerCar(Car car) throws RemoteException;
}
