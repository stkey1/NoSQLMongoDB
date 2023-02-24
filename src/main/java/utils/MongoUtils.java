package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
public class MongoUtils {
    public static final String uri = "mongodb://localhost:27017";

    public static MongoCollection<Document> getCollection(){

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("mongotest");
            return database.getCollection("filmler");
        }
    }
}
