package lk.shanga.RentalVehicleManager.manager;

import lk.shanga.RentalVehicleManager.dataBase.Database;
import lk.shanga.RentalVehicleManager.pojo.Car;
import lk.shanga.RentalVehicleManager.pojo.Motorbike;
import lk.shanga.RentalVehicleManager.pojo.Vehicle;
import org.bson.Document;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    Database database; // Database Object Declaration
    public List<Vehicle> vehicles = new ArrayList<Vehicle>(); // Create the Array list for Store


    public WestminsterRentalVehicleManager() {
        database = new Database(); // Database Object Initiation
        // Get the data from Database Object
        for (Document document : database.getData()){
            //Check Vehicle Type
            if (document.getString("Vehicle Type").equals("Car")){
                vehicles.add(new Car("Car",document.getString("Plate Number"),document.getDouble("Price"),document.getString("Brand"),document.getString("Model"),document.getString("Colour"),document.getString("Fuel Type"),document.getDouble("Maximum Speed"),document.getDouble("Engine Capacity"),document.getString("Transmission Type"),document.getInteger("Number Of Passengers"),document.getInteger("Number Of Doors"), document.getString("Have AC").equals("Yes")));
            }if (document.getString("Vehicle Type").equals("Motorbike")){
                vehicles.add(new Motorbike("Motorbike",document.getString("Plate Number"),document.getDouble("Price"),document.getString("Brand"),document.getString("Model"),document.getString("Colour"),document.getString("Fuel Type"),document.getDouble("Maximum Speed"),document.getDouble("Engine Capacity"),document.getString("Transmission Type"),document.getString("Front Break"),document.getString("Rear Break"), document.getString("Self Start").equals("Yes")));
            }
        }

    }

    @Override
    public void addVehicle() {
        Scanner scAdd = new Scanner(System.in);
        System.out.println("Welcome to the Westminster Rental Vehicle System");
        System.out.println("\t"+"A : Car  ||  B : Motorbike ");
        System.out.println("Please Choose Your Vehicle Category (A/B) : ");
        String choice = scAdd.nextLine().toUpperCase();
        //Get the category and changed to uppercase letter
        while (!choice.equals("A") && !choice.equals("B")) {
            System.out.println("Please Enter Valid Category : ");
            choice = scAdd.nextLine().toUpperCase();
        }

        System.out.println("Please Enter Correct Details of the Vehicle");
        System.out.println("Number Plate : ");
        String plateNumber = scAdd.nextLine().toUpperCase();
        System.out.println("Price (Per day) : ");
        // Stop strings when we enter Price
        while (!scAdd.hasNextDouble()){
            System.out.println("Invalid Entry!!, Re-enter : ");
            scAdd.next();
        }
        double price = scAdd.nextDouble();
        scAdd.nextLine(); //change the different type
        System.out.println("Brand : ");
        String brand = scAdd.nextLine();
        //First letter save as uppercase
        brand = brand.substring(0,1).toUpperCase() + brand.substring(1);
        System.out.println("Model : ");
        String model = scAdd.nextLine();
        //First letter save as uppercase
        model = model.substring(0,1).toUpperCase() + model.substring(1).toLowerCase();
        System.out.println("Colour : ");
        String colour = scAdd.nextLine();
        //First letter save as uppercase
        colour = colour.substring(0,1).toUpperCase() + colour.substring(1).toLowerCase();
        System.out.println("Fuel Type : ");
        String fuelType = scAdd.nextLine();
        //First letter save as uppercase
        fuelType = fuelType.substring(0,1).toUpperCase() + fuelType.substring(1).toLowerCase();
        System.out.println("Maximum Speed (KMPH) : ");
        // Stop strings when we enter Price
        while (!scAdd.hasNextDouble()){
            System.out.println("Invalid Entry!!, Re-enter : ");
            scAdd.next();
        }
        double maximumSpeed = scAdd.nextDouble();
        System.out.println("Engine Capacity (cc): ");
        // Stop strings when we enter Price
        while (!scAdd.hasNextDouble()){
            System.out.println("Invalid Entry!!, Re-enter : ");
            scAdd.next();
        }
        double engineCapacity = scAdd.nextDouble();
        scAdd.nextLine();
        System.out.println("Transmission Type (Auto/Manual) : ");
        String transmissionType = scAdd.nextLine();
        //First letter save as uppercase
        transmissionType = transmissionType.substring(0,1).toUpperCase() + transmissionType.substring(1).toLowerCase();

        // If We select Car option, it will work
        if (choice.equals("A")){
            Scanner scCar = new Scanner(System.in);
            System.out.println("Number of Passengers : ");
            // Stop strings when we enter Passengers
            while (!scCar.hasNextInt()){
                System.out.println("Invalid Entry!!, Re-enter : ");
                scCar.next();
            }
            int numOfPassenger = scCar.nextInt();
            System.out.println("Number of Doors : ");
            // Stop strings when we enter Doors
            while (!scCar.hasNextInt()){
                System.out.println("Invalid Entry!!, Re-enter : ");
                scCar.next();
            }
            int numOfDoors = scCar.nextInt();
            // Air Condition boolean
            boolean carAC = false;
            System.out.println("Air Conditioning (y/n) : ");
            String airConditioning = scCar.next().toLowerCase();
            //Get the category and changed to uppercase letter
            while (!airConditioning.equals("y") && !airConditioning.equals("n")) {
                System.out.println("Invalid Entry!!, Re-enter : ");
                airConditioning = scCar.next().toLowerCase();
            }
            if (airConditioning.equals("y")){
                carAC = true;
            } else {
                carAC = false;
            }
            

            if (vehicles.size()<=50){
                // Add to array list and Database
                vehicles.add(new Car("Car",plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType,numOfPassenger,numOfDoors,carAC));
                database.insert(new Car("Car",plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType,numOfPassenger,numOfDoors,carAC));

            }else{
                System.out.println("Storage full");
            }

        }
        // If We select Motorbike option, it will work
            else {
            Scanner scMotorbike = new Scanner(System.in);
            System.out.println("Select Your Front Break Type"); //Front Break
            System.out.println("\t"+"A : Simple Drum brakes");
            System.out.println("\t"+"B : Simple Disc brakes");
            System.out.println("\t"+"C : Anti-lock braking system ");
            System.out.println("\t"+"D : Combined braking system");
            System.out.println("Your Selection is : ");
            String frontBreak = scMotorbike.nextLine().toUpperCase();
            //Get the selection and changed to uppercase letter
            while (!frontBreak.equals("A") && !frontBreak.equals("B") && !frontBreak.equals("C") && !frontBreak.equals("D")) {
                System.out.println("Invalid Selection!!, Re-enter : ");
                frontBreak = scMotorbike.nextLine().toUpperCase();
            }
            String frBreak;
                if (frontBreak.equals("A")){
                    frBreak = "Simple Drum brakes";
                } else if (frontBreak.equals("B")){
                    frBreak = "Simple Disc brakes";
                } else if (frontBreak.equals("C")){
                    frBreak = "Anti-lock braking system";
                } else {
                    frBreak = "Combined braking system";
                }

            System.out.println("Select Your Rear Break Type"); // Rear break
            System.out.println("\t"+"A : Simple Drum brakes");
            System.out.println("\t"+"B : Simple Disc brakes");
            System.out.println("\t"+"C : Anti-lock braking system ");
            System.out.println("\t"+"D : Combined braking system");
            System.out.println("Your Selection is : ");
            String rearBreak = scMotorbike.nextLine().toUpperCase();
            //Get the selection and changed to uppercase letter
            while (!rearBreak.equals("A") && !rearBreak.equals("B") && !rearBreak.equals("C") && !rearBreak.equals("D")) {
                System.out.println("Invalid Selection!!, Re-enter : ");
                rearBreak = scMotorbike.nextLine().toUpperCase();
            }
            String reBreak;
                if (rearBreak.equals("A")){
                    reBreak = "Simple Drum brakes";
                } else if (rearBreak.equals("B")){
                    reBreak = "Simple Disc brakes";
                } else if (rearBreak.equals("C")){
                    reBreak = "Anti-lock braking system";
                } else {
                    reBreak = "Combined braking system";
                }
            // Self start boolean
            boolean selfStart = false;
            System.out.println("Self Start (y/n) : ");
                String bikeSelfStart = scMotorbike.nextLine().toLowerCase();
                //Get the category and changed to uppercase letter
                while (!bikeSelfStart.equals("y") && !bikeSelfStart.equals("n")) {
                    System.out.println("Invalid Entry!!, Re-enter : ");
                    bikeSelfStart = scMotorbike.nextLine().toLowerCase();
                }
                if (bikeSelfStart.equals("y")){
                    selfStart = true;
                } else {
                    selfStart = false;
                }

            if (vehicles.size()<=50){
                // Add to Array list and Database
                vehicles.add(new Motorbike("Motorbike",plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType,frBreak,reBreak,selfStart));
                database.insert(new Motorbike("Motorbike",plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType,frBreak,reBreak,selfStart));

            }else{
                System.out.println("Storage Almost Full");
                System.out.println("Sorry, You can't register your vehicle");
            }

        }

    }

    @Override
    public void deleteVehicle() {
        //Scanner for Delete Items
        Scanner scDelete = new Scanner(System.in);
        System.out.println("Your Vehicle will be Delete");
        Database database = new Database();
        System.out.println("Enter Your Vehicle No : ");
        String input = scDelete.next().toUpperCase();
        System.out.println("Searching.........");
        List<Document> documents  = database.getData("Plate Number",input);

        // Check the data
        if (!documents.isEmpty()){
            for (Document document : documents) {
                database.delete(document); // Delete the data from Database
            }
            //Array list delete
            boolean deleted = false;
            for (Vehicle vehicle : vehicles){
                if(vehicle.getPlateNumber().equals(input)){
                    vehicles.remove(vehicle);
                    deleted = true;
//                    System.out.println("\t"+"Successfully Deleted your Vehicle!");
                    break;
                }
            }
            if (!deleted){
//                System.out.println("\t"+"Your Vehicle not found!!!");

            }

        } else {
            //If Id is unavailable
            System.out.println("Sorry! Vehicle not Available!!!");
            System.out.println("");
        }
    }

    @Override
    public void printListOfVehicles() {
        System.out.println("Details of the registered vehicle");
        Collections.sort(vehicles); // Sorting by Alphabetic Order
        // Print the Register vehicles in for loop
        for (Vehicle checkVehicle : vehicles){
            if (checkVehicle instanceof Car){
                System.out.println("\t"+"Your Vehicle type is Car ");
                System.out.println("\t"+"\t"+" Plate Number is " + checkVehicle.getPlateNumber());
            } else if (checkVehicle instanceof Motorbike){
                System.out.println("\t"+"Your Vehicle type is Motorbike");
                System.out.println("\t"+"\t"+" Plate Number is " + checkVehicle.getPlateNumber());
            }
        }
    }

    @Override
    public void writeOrSave() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("Store.txt", "UTF-8"); // Generator type
        // Print the Vehicles in for loop
        writer.println("Registered vehicles are here,");
        for (Vehicle vehicleArray : vehicles){
            if (vehicleArray instanceof Car){
                writer.println(vehicleArray.toString());
            } else if (vehicleArray instanceof Motorbike) {
                    writer.println(vehicleArray.toString());
                }

        }
        writer.close();
        System.out.println("Successfully Completed!!");
        System.out.println("Check your Store.txt file");

    }


    @Override
    public List<Vehicle> allVehicles() {
        return vehicles;
    } // Allow access to other class




}
