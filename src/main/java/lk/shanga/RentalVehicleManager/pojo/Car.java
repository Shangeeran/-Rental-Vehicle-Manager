package lk.shanga.RentalVehicleManager.pojo;

public class Car extends Vehicle {
    private int numberOfPassengers;
    private int numberOfDoors;
    private boolean haveAC;


    public Car(int numberOfPassengers, int numberOfDoors, boolean haveAC) {
        this.numberOfPassengers = numberOfPassengers;
        this.numberOfDoors = numberOfDoors;
        this.haveAC = haveAC;
    }

    public Car(String vehicleType, String plateNumber, double price, String brand, String model, String colour, String fuelType, double maximumSpeed, double engineCapacity, String transmissionType, int numberOfPassengers, int numberOfDoors, boolean haveAC) {
        super(vehicleType, plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType);
        this.numberOfPassengers = numberOfPassengers;
        this.numberOfDoors = numberOfDoors;
        this.haveAC = haveAC;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isHaveAC() {
        return haveAC;
    }

    public void setHaveAC(boolean haveAC) {
        this.haveAC = haveAC;
    }


    @Override
    public String toString() {
        return '\n'+"Car {" +'\n'+ super.toString()+
                "\t"+" numberOfPassengers    = " + numberOfPassengers +'\n'+
                "\t"+" numberOfDoors         = " + numberOfDoors +'\n'+
                "\t"+" haveAC                = " + (haveAC?"Yes":"No") +'\n'+
                "\t"+" } ";
    }
}
