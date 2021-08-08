package demo;

import java.rmi.RemoteException;

public interface iCar extends java.rmi.Remote{

    String plateNum(Car plate) throws RemoteException;

}
