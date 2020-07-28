package com.mx3.somethingtodo.data.model;

public class Activity {

    private String key;
    private String name;
    private String url;

    // Constructor

    public Activity(String key, String name, String url) {
        this.key = key;
        this.name = name;
        this.url = url;
    }

    // Getters and setters

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
