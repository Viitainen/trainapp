package com.example.arto.swipeview.train;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

/**
 * Created by Arto on 7.11.2016.
 */

public class TrainAPI {

    private static final String API_URL = "http://rata.digitraffic.fi/api/v1/";
    private static final Uri API_URI = Uri.parse("http://rata.digitraffic.fi/api/v1/");

    public static String getTrainOnTime(String trainId) {

        try {
            Uri.Builder builder = API_URI.buildUpon();
            builder.appendPath("live-trains");
            builder.appendPath(trainId);

            Log.d("JUNA", ""+builder.toString());
            return readUrl(builder.toString());

        } catch (Exception e) {
            Log.d("JUNA", e.getMessage());
        }
        return "";
    }

    ///history/<train_number>?departure_date=<departure_date>
    public static String getTrainOnTimeHistory(String trainId, String date) {
        try {
            Uri.Builder builder = API_URI.buildUpon();
            builder.appendPath("history");
            builder.appendPath(trainId);
            builder.appendQueryParameter("departure_date", date);

            Log.d("JUNA", "URL: " + builder.toString());
            return readUrl(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getTrainsFromStationToStationAtDate(String placeA, String placeB, String date) {

        try {
            Uri.Builder builder = API_URI.buildUpon();
            Log.d("JUNA", date);
            builder.appendPath("schedules");
            builder.appendQueryParameter("departure_station", placeA.toUpperCase());
            builder.appendQueryParameter("arrival_station", placeB.toUpperCase());
            builder.appendQueryParameter("departure_date", date);

            Log.d("JUNA", builder.toString());
            return readUrl(builder.toString());
        } catch (Exception e) {
            Log.d("JUNA", e.getMessage());
        }

        return "";
    }

    public static String getStationsArrivalsAndDepartures(String stationCode) {

        try {
            Uri.Builder builder = API_URI.buildUpon();
            builder.appendPath("live-trains");
            builder.appendQueryParameter("minutes_before_departure","20");
            builder.appendQueryParameter("minutes_after_departure","0");
            builder.appendQueryParameter("minutes_before_arrival","20");
            builder.appendQueryParameter("minutes_after_arrival","0");
            builder.appendQueryParameter("station", stationCode);

            return readUrl(builder.toString());

            //return readUrl(API_URL + "live-trains?minutes_before_departure=20&minutes_after_departure=0&minutes_before_arrival=20&minutes_after_arrival=0&station=" + stationCode);
        } catch (Exception e) {
            Log.d("JUNA", e.getMessage());
        }

        return "";
    }

    public static String getCompositions(String trainId, String date) {

        try {
            Uri.Builder builder = API_URI.buildUpon();
            builder.appendPath("compositions");
            builder.appendPath(trainId);
            builder.appendQueryParameter("departure_date", date);

            return readUrl(builder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

}
