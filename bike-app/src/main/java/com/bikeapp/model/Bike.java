package com.bikeapp.model;

public class Bike {

    private final long id;
    private final String content;

    public Bike(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
