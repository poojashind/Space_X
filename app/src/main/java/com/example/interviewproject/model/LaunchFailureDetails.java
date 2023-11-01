package com.example.interviewproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchFailureDetails {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("altitude")
    @Expose
    private Object altitude;
    @SerializedName("reason")
    @Expose
    private String reason;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Object getAltitude() {
        return altitude;
    }

    public void setAltitude(Object altitude) {
        this.altitude = altitude;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}