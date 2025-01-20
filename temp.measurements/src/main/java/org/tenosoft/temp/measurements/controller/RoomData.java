package org.tenosoft.temp.measurements.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class  RoomData {
    @JsonProperty("roomId")
    long roomId;
    @JsonProperty("roomName")
    String roomName;
    @JsonProperty("roomDescription")
    String description;

    @JsonProperty("temperature")
    double istTemp;

    @JsonProperty("sollTemperature")
    double sollTemp;

    public  RoomData() {

    }

    public RoomData(long roomId, String roomName, String description) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.description = description;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getIstTemp() {
        return istTemp;
    }

    public void setIstTemp(double istTemp) {
        this.istTemp = istTemp;
    }

    public double getSollTemp() {
        return sollTemp;
    }

    public void setSollTemp(double sollTemp) {
        this.sollTemp = sollTemp;
    }
}
