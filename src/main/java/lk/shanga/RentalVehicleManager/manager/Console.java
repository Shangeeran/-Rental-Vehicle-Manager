package lk.shanga.RentalVehicleManager.manager;

import lk.shanga.RentalVehicleManager.booking.Booking;
import lk.shanga.RentalVehicleManager.booking.RequestSchedule;
import lk.shanga.RentalVehicleManager.booking.Schedule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lk.shanga.RentalVehicleManager.pojo.Vehicle;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class Console extends Vehicle {
    private static RentalVehicleManager actions; // Initiation of Westminster Vehicle Manager
    private static Booking booking; // Declaration Booking Object

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        actions = new WestminsterRentalVehicleManager(); // Declaration Westminster Vehicle Manager Object
        booking = new Booking(); // Initiation of Booking
        Scanner scOption = new Scanner(System.in);
        int option;
        do {
            System.out.println();
            System.out.println("Welcome to the Westminster Rental Vehicle Manager");
            System.out.println("1 : Add a new Vehicle");
            System.out.println("2 : Delete a Vehicle");
            System.out.println("3 : Print the list of the Vehicle");
            System.out.println("4 : Generate the Report");
            System.out.println("5 : Print the list of Booked Vehicles");
            System.out.println("6 : Open GUI");
            System.out.println("7 : Exit Programme");
            System.out.println("Your Option is : ");
            // Stop strings when we enter Option
            while (!scOption.hasNextInt()) {
                System.out.println("Invalid Entry!!! Re-enter : ");
                scOption.next();
            }
            // Get the option from user assign to option variable
            option = scOption.nextInt();



            switch (option) {
                case 1:
                    actions.addVehicle();
                    break;
                case 2:
                    actions.deleteVehicle();
                    break;
                case 3:
                    actions.printListOfVehicles();
                    break;
                case 4:
                    actions.writeOrSave();
                    break;
                case 5:
                    bookedVehicles();
                    break;
                case 6:
                    SpringApplication.run(Console.class, args);
                    break;
                case 7:
                    System.out.println("You’re Welcome!!!");
                    break;
                default:
                    System.out.println("Invalid Option!!! Re-enter...");
            }

        } while(option!=7);
    }

    // Spring boot router path for view all vehicle
    @CrossOrigin(origins = "http://localhost:3000") // Allow access to client server
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET) // Route Configuration
    @ResponseBody // To view the data
    public List<Vehicle> vehicles(){
        return actions.allVehicles();
    }


    // Spring boot router path for booking
    @CrossOrigin(origins = "http://localhost:3000") // Allow access to client server
    @RequestMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE) // Route Configuration
    @ResponseBody // To view the data
    public Schedule book(@RequestBody RequestSchedule requestSchedule){
        Schedule schedule = new Schedule(requestSchedule.getNumberPlate(),requestSchedule.getCustomerName(),requestSchedule.getContactNumber(),requestSchedule.getNicNumber(),new Date(requestSchedule.getPickUpDate()),new Date(requestSchedule.getDropDate()));
        booking.add(schedule);
        return schedule;
    }

    public static void bookedVehicles() {
        System.out.println("Registered vehicles are here");
        // Print the Register vehicles in for loop
        for (Schedule checkVehicle : booking.list()){
            System.out.println(checkVehicle.toString());
        }
    }



}
