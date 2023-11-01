package com.example.interviewproject.data.roomdatabse;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import com.example.interviewproject.model.Rocket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

@ProvidedTypeConverter
public class SpaceConverter {
  @TypeConverter
  public Rocket StringToExample(String string) {

  }

  @TypeConverter
  public String ExampleToString(Rocket rocket) {
    if (rocket == null) {
      return (null);
    }
    Gson gson = new Gson();
    Type type = new TypeToken<Rocket>() {
    }.getType();
    String json = gson.toJson(rocket, type);
    return json;
  }
}