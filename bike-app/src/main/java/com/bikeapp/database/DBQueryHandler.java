package com.bikeapp.database;

import com.bikeapp.utils.JsonParser;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONException;

import java.net.UnknownHostException;

public class DBQueryHandler {

    //Set up properties for mongodb connection
    //TODO: Move to properties file
    Mongo mongoClient;
    String host = "192.168.99.100";
    int port = 27017;
    String dbName = "test";

    //method to return all data from the bike collection
    public String getAllBikes() {

        //connect to mongoDB and query all data in the bike collection.  Return as String
        try {
            mongoClient = new Mongo(host, port);
            DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");
            DBCursor cursor = collection.find();
            JSON json = new JSON();
            String jsonToString = json.serialize(cursor);
            return JsonParser.getStrippedJsonString(jsonToString);

            //if issues with the above connection or query then return error
        } catch (UnknownHostException e) {
            return "Error: Could not connect to DB and return All Bikes";
        }
    }

    public String getBikeById(int bikeId) {

        //connect to mongoDB and query all data in the bike collection.  Return as String
        try {
            mongoClient = new Mongo(host, port);
            DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");

            BasicDBObject query = new BasicDBObject();
            query.put("bikeId", bikeId);
            DBCursor cursor = collection.find(query);

            JSON json = new JSON();
            String jsonToString = json.serialize(cursor);
            return JsonParser.getStrippedJsonString(jsonToString);
            //if issues with the above connection or query then return error
        } catch (UnknownHostException e) {
            return "Error: Could not query by Bike ID, please ensure it is specified as a parameter '?bikeId=' and is a valid Integer";
        }
    }

    public String createBike(String bikeName, String bikeDescription, String bikePrice) {

        int newBikeId = getMaxBikeId() + 1;

        //TODO: create bike class to handle properties
        BasicDBObject bikeDocument = new BasicDBObject();
        bikeDocument.put("bikeId", newBikeId);
        bikeDocument.put("name", bikeName);
        bikeDocument.put("decsription", bikeDescription);
        bikeDocument.put("price", bikePrice);

        //connect to mongoDB and query all data in the bike collection.  Return as String
        try {
            mongoClient = new Mongo(host, port);
            DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");
            collection.insert(bikeDocument);

            return "Success: Bike created with id: " + newBikeId;

            //if issues with the above connection and query then return error
        } catch (UnknownHostException e) {
            return "Error: unable to create Bike in database";
        }
    }

    //function to get maximum bike id currently being used in the db
    public int getMaxBikeId() {

        int newBikeId = 0;
        String bikeIdString = "";

        try {
            mongoClient = new Mongo(host, port);

            DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");
            //query to find max bike id
            DBCursor cursor = collection.find().sort(new BasicDBObject("bikeId", -1)).limit(1);
            String dBCursorToString = JSON.serialize(cursor);

            try {
                bikeIdString = JsonParser.getStrippedJsonObject(dBCursorToString).getString("bikeId");
                newBikeId = Integer.parseInt(bikeIdString);

            } catch (JSONException e){
                System.out.println(e);
            }
            return newBikeId;
            //if issues with the above connection or query then handle error
        } catch (UnknownHostException e) {
            System.out.print("ERROR: Unable to query database to get the maximum bike id");
        }
        return newBikeId;
    }
}