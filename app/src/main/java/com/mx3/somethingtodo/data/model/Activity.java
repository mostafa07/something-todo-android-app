package com.mx3.somethingtodo.data.model;

import com.google.gson.annotations.SerializedName;

public class Activity {

    private String key;
    @SerializedName("activity")
    private String name;
    private String type;
    @SerializedName("participants")
    private Integer numParticipants;
    @SerializedName("link")
    private String url;
    private Double price;
    private Double accessibility;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(Integer numParticipants) {
        this.numParticipants = numParticipants;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Double accessibility) {
        this.accessibility = accessibility;
    }
}
