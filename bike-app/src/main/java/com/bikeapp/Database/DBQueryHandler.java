package com.bikeapp.Database;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.UnknownHostException;

public class DBQueryHandler {

    //set up mongodb properties - Move to properties file
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
            //taken from git db.getCollection('bike').find({})
            DBCursor cursor = collection.find();
            JSON json = new JSON();
            String jsonToString = json.serialize(cursor);
            return jsonToString;
            //if issues with the above connection and query then return error
        } catch (UnknownHostException e) {
            return "Error: Could not connect to DB and return All Bikes";
        }
    }

    public String getBikeById(int bikeId) {
        //DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");
        //db.getCollection('bike').find({bikeId:2})
        //connect to mongoDB and query all data in the bike collection.  Return as String
        try {
            mongoClient = new Mongo(host, port);
            DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");

            BasicDBObject query = new BasicDBObject();
            query.put("bikeId", bikeId);
            DBCursor cursor = collection.find(query);

            JSON json = new JSON();
            String jsonToString = json.serialize(cursor);
            return jsonToString;
            //if issues with the above connection and query then return error
        } catch (UnknownHostException e) {
            return "Error: Could not query by Bike ID, please ensure it is specified as a parameter '?bikeId=' and is a valid Integer";
        }
    }

    public String createBike(String bikeName, String bikeDescription, String bikePrice) {

        int newBikeId = getMaxBikeId() + 1;

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

    public int getMaxBikeId() {

        int newBikeId = 0;
        String bikeIdString = "";

        try {
            mongoClient = new Mongo(host, port);

            DBCollection collection = mongoClient.getDB(dbName).getCollection("bike");
            DBCursor cursor = collection.find().sort(new BasicDBObject("bikeId", -1)).limit(1);
            //DBCursor cursor = collection.find();
            String dBCursorToString = JSON.serialize(cursor);

            try {

                int indexOfOpenBracket = dBCursorToString.indexOf("[");
                int indexOfLastBracket = dBCursorToString.lastIndexOf("]");

                JSONObject jsonResponse = new JSONObject(dBCursorToString.substring(indexOfOpenBracket+1, indexOfLastBracket));
                bikeIdString = jsonResponse.getString("bikeId");
                newBikeId = Integer.parseInt(bikeIdString);
            } catch (JSONException e){
                System.out.println(e);
            }
            return newBikeId;
            //if issues with the above connection and query then return error
        } catch (UnknownHostException e) {
            //
        }
        return newBikeId;
    }
}