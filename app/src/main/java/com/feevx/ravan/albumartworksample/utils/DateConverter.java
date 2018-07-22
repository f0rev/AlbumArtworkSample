package com.feevx.ravan.albumartworksample.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
    private static SimpleDateFormat sApiDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static SimpleDateFormat sUiDateFormat = new SimpleDateFormat("MMM dd, yyyy");
    private static DateFormat sUiTrackLengthFormat = new SimpleDateFormat("mm:ss"); // Just the year, with 2 digits
    private static Calendar sCalendar = Calendar.getInstance();


    public static String getUiDate(String apiDate) {
        try {
            Date dt = sApiDateFormat.parse(apiDate);
            return sUiDateFormat.format(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return apiDate;
    }

    public static String getCorrectTrackLength(String millisecsLength) {
        long t = Long.parseLong(millisecsLength);
        sCalendar.setTimeInMillis(t);
        String time = sUiTrackLengthFormat.format(sCalendar.getTime());

        return time;

    }

}
