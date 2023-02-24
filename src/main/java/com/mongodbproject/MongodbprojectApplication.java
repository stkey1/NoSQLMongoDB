package com.mongodbproject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import service.OgrenciService;
import utils.MongoUtils;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MongodbprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbprojectApplication.class, args);
		String uri = "mongodb://localhost:27017/";
		MongoUtils.getCollection();

		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase("mongotest");
			MongoCollection<Document> collection = database.getCollection("filmler");
			OgrenciService ogrenciService = new OgrenciService();
			ogrenciService.addOgrenci(collection);
			ogrenciService.addMovies(collection);
			ogrenciService.getMovies(collection);
		}

	}
}
