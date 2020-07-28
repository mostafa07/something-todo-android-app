package com.mx3.somethingtodo.enums;

public enum ActivityTypeEnum {

    EDUCATION("education"),
    RECREATIONAL("recreational"),
    SOCIAL("social"),
    DIY("diy"),
    CHARITY("charity"),
    COOKING("cooking"),
    RELAXATION("relaxation"),
    MUSIC("music"),
    BUSYWORK("busywork");

    private String type;

    ActivityTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
