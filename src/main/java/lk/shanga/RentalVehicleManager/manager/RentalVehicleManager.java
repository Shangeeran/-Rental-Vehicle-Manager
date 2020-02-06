package lk.shanga.RentalVehicleManager.manager;

import lk.shanga.RentalVehicleManager.pojo.Vehicle;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface RentalVehicleManager {
    void addVehicle();
    void deleteVehicle();
    void printListOfVehicles();
    void writeOrSave() throws FileNotFoundException, UnsupportedEncodingException;
    List<Vehicle> allVehicles();

}
