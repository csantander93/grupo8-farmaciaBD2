package com.proyectofarmaciaBD2.dao;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static MongoClient mongoClient;

    public static MongoDatabase connectToDatabase(String dbName) {
        if (mongoClient == null) {
            MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
            mongoClient = new MongoClient(uri);
        }
        return mongoClient.getDatabase(dbName);
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
