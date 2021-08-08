package ws10;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CarClient {


    public static void main(String[] args) {
        try {
            System.out.println("Registration new car");

            Car car = new Car("Toyota", "Yellow", 160.7);

            CarInterface c = (CarInterface) Naming.lookup("rmi://localhost:1099/CarService");

            car.setPlate(c.registerCar(car));
            System.out.println(car);

        } catch (MalformedURLException murle) {
            System.out.println(murle.getMessage());
        } catch (RemoteException re) {
            System.out.println(re.getMessage());
        } catch (NotBoundException nbe) {
            System.out.println(nbe.getMessage());
        }

    }
}
