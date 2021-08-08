package demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class iCarImpl extends UnicastRemoteObject implements iCar{

    protected iCarImpl() throws RemoteException {
        super();
    }

    @Override
    public String plateNum(Car plate) throws RemoteException{
        return String.valueOf(plate.hashCode());

    }
}
