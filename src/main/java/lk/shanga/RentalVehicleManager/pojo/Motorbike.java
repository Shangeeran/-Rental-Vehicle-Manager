package lk.shanga.RentalVehicleManager.pojo;

public class Motorbike extends Vehicle {
    private String frontBreak;
    private String rearBreak;
    private boolean selfStart;

    public Motorbike(String frontBreak, String rearBreak, boolean selfStart) {
        this.frontBreak = frontBreak;
        this.rearBreak = rearBreak;
        this.selfStart = selfStart;
    }

    public Motorbike(String vehicleType, String plateNumber, double price, String brand, String model, String colour, String fuelType, double maximumSpeed, double engineCapacity, String transmissionType, String frontBreak, String rearBreak, boolean selfStart) {
        super(vehicleType, plateNumber, price, brand, model, colour, fuelType, maximumSpeed, engineCapacity, transmissionType);
        this.frontBreak = frontBreak;
        this.rearBreak = rearBreak;
        this.selfStart = selfStart;
    }

    public String getFrontBreak() {
        return frontBreak;
    }

    public void setFrontBreak(String frontBreak) {
        this.frontBreak = frontBreak;
    }

    public String getRearBreak() {
        return rearBreak;
    }

    public void setRearBreak(String rearBreak) {
        this.rearBreak = rearBreak;
    }

    public boolean isSelfStart() {
        return selfStart;
    }

    public void setSelfStart(boolean selfStart) {
        this.selfStart = selfStart;
    }

    @Override
    public String toString() {
        return '\n'+"Motorbike {" +'\n'+ super.toString()+
                "\t"+" frontBreak            = " + frontBreak +'\n'+
                "\t"+" rearBreak             = " + rearBreak +'\n'+
                "\t"+" selfStart             = " + (selfStart?"Yes":"No") +'\n'+
                "\t"+" } ";
    }

}
