package com.bikeapp.database;

import com.mongodb.Mongo;

//Redundant class
//TODO: use class to create connection objects for mongodb
public class DBConnectionFactory {

    private Mongo client = null;

    private void ConnectionFactory() {
        try {
            client = new Mongo();
        } catch (Exception e) {
            // Log it.
        }
    }

    public Mongo getClient() {
        if (client == null)
            throw new RuntimeException();
        return client;
    }
}
