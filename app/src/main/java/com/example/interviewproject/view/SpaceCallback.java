package com.example.interviewproject.view;

import com.example.interviewproject.model.SpaceXLaunchResponse;

public interface SpaceCallback {

    void update(boolean isBookMark, int flightNumber);

    void loadDetailsPage(SpaceXLaunchResponse response);
}
