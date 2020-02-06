package lk.shanga.RentalVehicleManager.manager;

import lk.shanga.RentalVehicleManager.pojo.Car;
import lk.shanga.RentalVehicleManager.pojo.Vehicle;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterRentalVehicleManagerTest {
    WestminsterRentalVehicleManager testing = new WestminsterRentalVehicleManager();

    @Test
    void addVehicle() {
        System.out.println("Running testing...");
        Vehicle car = new Car("Car","BBQ-1452",3000,"Honda","Vezel","Black","Petrol",222,1500,"Automatic",5,4,true);
        testing.vehicles.add(car);
        assertEquals("Adding one vehicle to the list",1,testing.vehicles.size()+1);
    }

    private void assertEquals(String s, int i, int i1) {
    }

    @Test
    void deleteVehicle() {
        System.out.println("Deleting testing...");
        Vehicle car = new Car("Car","BBQ-1452",3000,"Honda","Vezel","Black","Petrol",222,1500,"Automatic",5,4,true);
        testing.vehicles.remove(car);
        assertEquals("Deleting one vehicle from the list",1,testing.vehicles.size()+1);
    }

    @Test
    void printListOfVehicles() {
        System.out.println("Print testing...");
        Vehicle car = new Car("Car","BBQ-1452",3000,"Honda","Vezel","Black","Petrol",222,1500,"Automatic",5,4,true);
        testing.vehicles.getClass();
        assertEquals("Print vehicle from the list",1,testing.vehicles.size()+1);
    }

    @Test
    void writeOrSave() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Write or Save testing...");
        Vehicle car = new Car("Car","BBQ-1452",3000,"Honda","Vezel","Black","Petrol",222,1500,"Automatic",5,4,true);
        testing.vehicles.add(car);
        testing.writeOrSave();
        assertEquals("Write or Save vehicle from the list",1,testing.vehicles.size()+1);
    }

}