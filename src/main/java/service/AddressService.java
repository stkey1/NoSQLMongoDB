package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import entity.Address;
import entity.Ogrenci;
import org.bson.Document;

/**
 * @author stkey
 * @customize
 * @add
 * @components
 * @throws
 * @return
 * @since 22.02.2023
 */
public class AddressService {
    public void addAddress(MongoCollection<Document> collection) {
        try {
            Address address = new Address("Ev", "Kazan1", 351, "Angar1", "166061");
            Ogrenci ogrenci = new Ogrenci("Ahmet", 212131,21);
            address.setOgrenci(ogrenci);

            Gson gson = new Gson();
            BasicDBObject dbObject = BasicDBObject.parse(gson.toJson(address));
            Document person = new Document();
            person.append("register1", dbObject);
            collection.insertOne(person);
            System.out.println("Registered successfully");
        }catch (Exception e) {
            System.err.println("Something went wrong while registering");
        }
    }
}
