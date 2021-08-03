package ws09;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImplementation extends UnicastRemoteObject implements CarInterface{
    public CarImplementation() throws RemoteException {
        super();
    }

    @Override
    public String registerCar(Car car) throws RemoteException {
        return car.hashCode()+"";
    }
}
