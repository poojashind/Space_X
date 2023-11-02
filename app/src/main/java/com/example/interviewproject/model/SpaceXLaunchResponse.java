package com.example.interviewproject.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "space_launch_table")
public class SpaceXLaunchResponse {
    @PrimaryKey
    @ColumnInfo(name = "flight_number")
    @SerializedName("flight_number")
    @Expose
    private int flightNumber;
    @ColumnInfo(name = "mission_name")

    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @ColumnInfo(name = "upcoming")

    @SerializedName("upcoming")
    @Expose
    private boolean upcoming;
    @ColumnInfo(name = "launch_year")

    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @ColumnInfo(name = "launch_date_unix")

    @SerializedName("launch_date_unix")
    @Expose
    private int launchDateUnix;
    @ColumnInfo(name = "launch_date_utc")

    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @ColumnInfo(name = "launch_date_local")

    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @ColumnInfo(name = "is_tentative")

    @SerializedName("is_tentative")
    @Expose
    private boolean isTentative;
    @ColumnInfo(name = "tentative_max_precision")

    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @ColumnInfo(name = "tbd")

    @SerializedName("tbd")
    @Expose
    private boolean tbd;
    @ColumnInfo(name = "launch_window")

    @SerializedName("launch_window")
    @Expose
    private int launchWindow;
    @ColumnInfo(name = "rocket")
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;

    @ColumnInfo(name = "launch_site")
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;

    @ColumnInfo(name = "launch_success")
    @SerializedName("launch_success")
    @Expose
    private boolean launchSuccess;
    @ColumnInfo(name = "links")
    @SerializedName("links")
    @Expose
    private Links links;

    @SerializedName("launch_failure_details")
    @Expose
    private LaunchFailureDetails launchFailureDetails;
    @ColumnInfo(name = "details")
    @SerializedName("details")
    @Expose
    private String details;
    @ColumnInfo(name = "static_fire_date_utc")
    @SerializedName("static_fire_date_utc")
    @Expose
    private String staticFireDateUtc;
    @ColumnInfo(name = "static_fire_date_unix")
    @SerializedName("static_fire_date_unix")
    @Expose
    private int staticFireDateUnix;
    @ColumnInfo(name = "timeline")
    @SerializedName("timeline")
    @Expose
    private Timeline timeline;

    @ColumnInfo(name = "is_bookmarked")
    private boolean isBookMarked;

    public boolean isBookMarked() {
        return isBookMarked;
    }

    public void setBookMarked(boolean bookMarked) {
        isBookMarked = bookMarked;
    }
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }


    public boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public int getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(int launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(boolean isTentative) {
        this.isTentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public boolean getTbd() {
        return tbd;
    }

    public void setTbd(boolean tbd) {
        this.tbd = tbd;
    }

    public int getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(int launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }


    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public int getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(int staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }



    public LaunchFailureDetails getLaunchFailureDetails() {
        return launchFailureDetails;
    }

    public void setLaunchFailureDetails(LaunchFailureDetails launchFailureDetails) {
        this.launchFailureDetails = launchFailureDetails;
    }
}
