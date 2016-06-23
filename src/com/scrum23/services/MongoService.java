package com.scrum23.services;

import com.mongodb.*;
import com.mongodb.client.*;

import java.util.Arrays;

public class MongoService {
    private static MongoService instance = null;
    private MongoDatabase db;

    /**
     * @author Jhonny Hardcode
     */
    protected MongoService() {
        MongoCredential credential = MongoCredential.createCredential("root", "grupo23scrum", "root".toCharArray());
        MongoClient mongoClient = new MongoClient( new ServerAddress("ds023912.mlab.com",23912), Arrays.asList(credential));
        this.db = mongoClient.getDatabase("grupo23scrum");
    }
    public static MongoService getInstance() {
        if(instance == null) {
            instance = new MongoService();
        }
        return instance;
    }
    public MongoDatabase getDb(){
        return this.db;
    }
}