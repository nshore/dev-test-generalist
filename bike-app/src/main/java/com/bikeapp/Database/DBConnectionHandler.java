package com.bikeapp.Database;

import com.mongodb.Mongo;

import java.net.UnknownHostException;

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
