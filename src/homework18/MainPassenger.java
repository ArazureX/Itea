package homework18;

import java.util.ArrayList;
import java.util.List;

public class MainPassenger {
    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Maks", "Pomoshko");
        Passenger passenger2 = new Passenger("Andrii", "Boiko");
        Passenger passenger3 = new Passenger("Anton", "Matsiuk");
        GunselPassenger gunselPassenger1 = new GunselPassenger("Maks Pomoshko", 1);
        GunselPassenger gunselPassenger2 = new GunselPassenger("Andrii Boiko", 2);
        GunselPassenger gunselPassenger3 = new GunselPassenger("Anton Matsiuk", 3);
        List<Passenger> listPassenger = new ArrayList<>();
        List<GunselPassenger> listGP = new ArrayList<>();
        listPassenger.add(passenger1);
        listPassenger.add(passenger2);
        listPassenger.add(passenger3);


    }

}
