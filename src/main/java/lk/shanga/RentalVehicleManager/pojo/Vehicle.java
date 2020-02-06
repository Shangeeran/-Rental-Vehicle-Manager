package lk.shanga.RentalVehicleManager.pojo;

import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle>{
    private String vehicleType;
    private String plateNumber;
    private double price;
    private String brand;
    private String model;
    private String colour;
    private String fuelType;
    private double maximumSpeed;
    private double engineCapacity;
    private String transmissionType;
//    private Schedule schedule;


    public Vehicle(String vehicleType, String plateNumber, double price, String brand, String model, String colour, String fuelType, double maximumSpeed, double engineCapacity, String transmissionType) {
        this.vehicleType = vehicleType;
        this.plateNumber = plateNumber;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.fuelType = fuelType;
        this.maximumSpeed = maximumSpeed;
        this.engineCapacity = engineCapacity;
        this.transmissionType = transmissionType;
    }

    public String getVehicleType() { return vehicleType; }

    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

//    public Schedule getSchedule() { return schedule; }

//    public void setSchedule(Schedule schedule) { this.schedule = schedule; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.price, price) == 0 &&
                Double.compare(vehicle.maximumSpeed, maximumSpeed) == 0 &&
                Double.compare(vehicle.engineCapacity, engineCapacity) == 0 &&
                vehicleType.equals(vehicle.vehicleType) &&
                plateNumber.equals(vehicle.plateNumber) &&
                brand.equals(vehicle.brand) &&
                model.equals(vehicle.model) &&
                colour.equals(vehicle.colour) &&
                fuelType.equals(vehicle.fuelType) &&
                transmissionType.equals(vehicle.transmissionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType);
    }

    @Override
    public String toString() {
        return
                "\t"+" plateNumber           = " + plateNumber +'\n'+
                "\t"+" price                 = " + price +'\n'+
                "\t"+" brand                 = " + brand +'\n'+
                "\t"+" model                 = " + model +'\n'+
                "\t"+" colour                = " + colour +'\n'+
                "\t"+" fuelType              = " + fuelType +'\n'+
                "\t"+" maximumSpeed          = " + maximumSpeed +'\n'+
                "\t"+" engineCapacity        = " + engineCapacity +'\n'+
                "\t"+" transmissionType      = " + transmissionType +'\n'
//                "\t"+" schedule              = " + schedule +'\n'+
                ;
    }

    public Vehicle() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }
}
