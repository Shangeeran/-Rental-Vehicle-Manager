package lk.shanga.RentalVehicleManager.booking;

import java.util.Date;

public class Schedule {
    private String numberPlate;
    private String customerName;
    private String contactNumber;
    private String nicNumber;
    private Date pickUpDate;
    private Date dropDate;

    public Schedule(String numberPlate, String customerName, String contactNumber, String nicNumber, Date pickUpDate, Date dropDate) {
        this.numberPlate = numberPlate;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.nicNumber = nicNumber;
        this.pickUpDate = pickUpDate;
        this.dropDate = dropDate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropDate() {
        return dropDate;
    }

    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }


    @Override
    public String toString() {
        return '\n'+ "Booked {" +
                "\n"+" numberPlate      =   " + numberPlate +
                "\n"+" customerName     =   " + customerName +
                "\n"+" contactNumber    =   " + contactNumber +
                "\n"+" nicNumber        =   " + nicNumber +
                "\n"+" pickUpDate       =   " + pickUpDate +
                "\n"+" dropDate         =   " + dropDate +'\n'+
                '}';
    }
}
