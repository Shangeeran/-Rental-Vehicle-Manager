package lk.shanga.RentalVehicleManager.booking;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    // Create the Array list for Booking
    private static List<Schedule> BookVehicles = new ArrayList<Schedule>();

    public void add(Schedule schedule){
        BookVehicles.add(schedule);
    }

    public List<Schedule> list(){
        return BookVehicles;
    }

}
