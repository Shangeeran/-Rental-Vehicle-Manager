package lk.shanga.RentalVehicleManager.dataBase;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lk.shanga.RentalVehicleManager.pojo.Car;
import lk.shanga.RentalVehicleManager.pojo.Motorbike;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.mongodb.client.model.Filters.eq;

public class Database {


    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> reservation;

    public Database() {
        mongoClient = MongoClients.create("mongodb+srv://shangeeran:shanga@shanga-c6536.mongodb.net/test?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("VehicleStore");
        reservation = database.getCollection("VehicleCollection");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

    }
    public List<Document> getData(){
        List<Document> documents = new ArrayList<Document>();
        for (Document cur : reservation.find()) {
            documents.add(cur);
        }
        return documents;
    }

    public List<Document> getData(String title, String find){
        List<Document> documents = new ArrayList<Document>();
        for (Document cur : reservation.find(eq(title,find))) {
            documents.add(cur);
        }
        return documents;
    }


    public void insert (Car car){
        System.out.println("");
        System.out.println("Loading..................");
        System.out.println("Updating Your Car Details");
        Document document = new Document("Plate Number", car.getPlateNumber())
                .append("Price",car.getPrice())
                .append("Brand",car.getBrand())
                .append("Model",car.getModel())
                .append("Colour",car.getColour())
                .append("Fuel Type",car.getFuelType())
                .append("Maximum Speed",car.getMaximumSpeed())
                .append("Engine Capacity",car.getEngineCapacity())
                .append("Transmission Type",car.getTransmissionType())
                .append("Number Of Passengers",car.getNumberOfPassengers())
                .append("Number Of Doors",car.getNumberOfDoors())
                .append("Have AC",car.isHaveAC()?"Yes":"No")
                .append("Vehicle Type","Car");
        reservation.insertOne(document);
        System.out.println("Successfully Registered!!");

    }

    public void insert (Motorbike motorbike){
        System.out.println("");
        System.out.println("Loading........................");
        System.out.println("Updating Your Motorbike Details");
        Document document = new Document("Plate Number", motorbike.getPlateNumber())
                .append("Price",motorbike.getPrice())
                .append("Brand",motorbike.getBrand())
                .append("Model",motorbike.getModel())
                .append("Colour",motorbike.getColour())
                .append("Fuel Type",motorbike.getFuelType())
                .append("Maximum Speed",motorbike.getMaximumSpeed())
                .append("Engine Capacity",motorbike.getEngineCapacity())
                .append("Transmission Type",motorbike.getTransmissionType())
                .append("Front Break",motorbike.getFrontBreak())
                .append("Rear Break",motorbike.getRearBreak())
                .append("Self Start",motorbike.isSelfStart()?"Yes":"No")
                .append("Vehicle Type","Motorbike");
        reservation.insertOne(document);
        System.out.println("Successfully Registered!!");

    }

    public void delete(Document document) {
//        System.out.println("Checking.........");
        System.out.println("Yes,Your Vehicle is Deleting...");
        reservation.deleteOne(eq("Plate Number",document.get("Plate Number")));
        System.out.println("Successfully Deleted your Vehicle.");
        System.out.println("Thank you! and Keep in touch with us.");
        System.out.println("");
    }
}
