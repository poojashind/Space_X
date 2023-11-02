package com.example.interviewproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeConverter {

    public static String getFormattedDateTime(String input) {

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String formattedDate = "";
        try {
            // Parse the input string into a Date object
            Date date = inputDateFormat.parse(input);

            // Set the desired output timezone if needed (e.g., UTC)
            outputDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            // Format the date as per the desired output format
            formattedDate = outputDateFormat.format(date);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  formattedDate;
    }
}
