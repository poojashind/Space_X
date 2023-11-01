package com.example.interviewproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeline {

@SerializedName("webcast_liftoff")
@Expose
private Integer webcastLiftoff;

public Integer getWebcastLiftoff() {
return webcastLiftoff;
}

public void setWebcastLiftoff(Integer webcastLiftoff) {
this.webcastLiftoff = webcastLiftoff;
}

}