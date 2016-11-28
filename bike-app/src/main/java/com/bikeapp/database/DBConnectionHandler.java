package com.bikeapp.database;

import com.mongodb.Mongo;

public class DBConnectionHandler {

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
