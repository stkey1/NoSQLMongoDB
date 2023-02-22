package service;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import entity.Address;
import entity.Ogrenci;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author stkey
 * @customize
 * @add
 * @components
 * @throws
 * @return
 * @since 22.02.2023
 */
public class OgrenciService {
    public void addOgrenci(MongoCollection<Document> collection) {

        try {
            Address address = new Address("Work", "Kazan", 35, "Angara", "16606");
            Ogrenci ogrenci = new Ogrenci("Mustafa", 23131, 12);
            ogrenci.setAddress(address);

            Gson gson = new Gson();
            BasicDBObject dbObject = BasicDBObject.parse(gson.toJson(ogrenci));
            Document ogrenci1 = new Document();
            ogrenci1.append("ogrenci", dbObject);
            collection.insertOne(ogrenci1);
            System.out.println("Başarılı şekilde kayıt edildi");
        } catch (Exception e) {
            System.err.println("Kayıt edilirken hata oluştu");
        }
    }

    public void addMovies(MongoCollection<Document> collection) {

        try {
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("adi", "Hard Target")
                    .append("türü", "Macera")
                    .append("oyuncular", Arrays.asList("Cüneyt Arkın", "Tarık Akan", "Kemal Sunal")));
            System.out.println("Başarılı şekilde kayıt edildi");
        } catch (MongoException me) {
            System.err.println("Kayıt edilirken hata oluştu: " + me);
        }
    }

    public void getMovies(MongoCollection<Document> collection) {

        try {
            FindIterable<Document> iterable = collection.find(eq("adi", "Hard Target"));
            MongoCursor<Document> cursor = iterable.iterator();
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
            System.out.println(collection.find(eq("adi", "Hard Target")));
        } catch (MongoException me) {
            System.err.println("Kayıt edilirken hata oluştu: " + me);
        }
    }
}
