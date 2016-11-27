package com.bikeapp.Database;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

public class DatabaseHandler {

    //set up mongodb properties - Move to properties file
    Mongo mongoClient;
    String host= "192.168.99.100";
    int port=27017;
    String dbName="test";

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

public String getBikeById(int bikeId){
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

//public String createBike(Int bikeId = 0; String bikeName = ""; String bikeDescription = "") {
//    }

//db.bike.insert({name:"Chopper",description:"Old school bike",price:"2500"})

//    private int getNewBikeId (){
//       return 1;
//    }
}