package com.example.interviewproject.data.roomdatabse;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.example.interviewproject.model.LaunchFailureDetails;
import com.example.interviewproject.model.LaunchSite;
import com.example.interviewproject.model.Links;
import com.example.interviewproject.model.Rocket;
import com.example.interviewproject.model.Timeline;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;

@ProvidedTypeConverter
public class SpaceConverter implements Serializable {
    @TypeConverter
    public Rocket StringToRocket(String rocketString) {
        if (rocketString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Rocket>() {
        }.getType();
        return gson.fromJson(rocketString, type);
    }

    @TypeConverter
    public String RocketToString(Rocket rocket) {
        if (rocket == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Rocket>() {
        }.getType();
        return gson.toJson(rocket, type);
    }

    @TypeConverter
    public LaunchSite StringToLaunchSite(String rocketString) {
        if (rocketString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<LaunchSite>() {
        }.getType();
        return gson.fromJson(rocketString, type);
    }

    @TypeConverter
    public String LaunchSiteToString(LaunchSite launchSite) {
        if (launchSite == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<LaunchSite>() {
        }.getType();
        return gson.toJson(launchSite, type);
    }

    @TypeConverter
    public Links StringToLinks(String linkString) {
        if (linkString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Links>() {
        }.getType();
        return gson.fromJson(linkString, type);
    }

    @TypeConverter
    public String LinksToString(Links links) {
        if (links == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Links>() {
        }.getType();
        return gson.toJson(links, type);
    }

    @TypeConverter
    public Timeline StringToTimeline(String timeLineString) {
        if (timeLineString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Timeline>() {
        }.getType();
        return gson.fromJson(timeLineString, type);
    }

    @TypeConverter
    public String timeLToineString(Timeline links) {
        if (links == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Timeline>() {
        }.getType();
        return gson.toJson(links, type);
    }

    @TypeConverter
    public LaunchFailureDetails StringToLaunchFailure(String timeLineString) {
        if (timeLineString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<LaunchFailureDetails>() {
        }.getType();
        return gson.fromJson(timeLineString, type);
    }

    @TypeConverter
    public String launchFailureToString(LaunchFailureDetails links) {
        if (links == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<LaunchFailureDetails>() {
        }.getType();
        return gson.toJson(links, type);
    }
}