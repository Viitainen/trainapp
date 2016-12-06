package com.example.arto.swipeview.train;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Arto on 17.11.2016.
 */

public class TrainStationToStationAtDate {

    private int trainNumber;

    private String departureStation;

    private String arrivalStation;

    private String arrivalTime;

    private String departureTime;


    public TrainStationToStationAtDate(int trainNumber, String departureStation, String arrivalStation, String departureTime, String arrivalTime) {
        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }


    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getArrivalTime() {
        return arrivalTime.replace("Z", "-0000");
    }

    public Date getArrivalTimeAsDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        Date date = new Date();

        try {
            date = df.parse(getArrivalTime());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public String getFormattedArrivalTime() {
        String time = "";

        try {
            SimpleDateFormat df = new SimpleDateFormat("E dd.MM HH:mm");
            time = df.format(getArrivalTimeAsDate());

        } catch(Exception e) {
            time = getArrivalTime();
            e.printStackTrace();
        }
        return time;

    }


    public void setArrivalTime(String time) {
        this.arrivalTime = time;
    }

    public String getDepartureTime() {
        return departureTime.replace("Z", "-0000");
    }

    public Date getDepartureTimeAsDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        Date date = new Date();

        try {
            date = df.parse(getDepartureTime());
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public String getFormattedDepartureTime() {
        String time = "";

        try {

            SimpleDateFormat df = new SimpleDateFormat("E dd.MM HH:mm");
            time = df.format(getDepartureTimeAsDate());

        } catch(Exception e) {
            time = getDepartureTime();
            e.printStackTrace();
        }
        return time;

    }

    public String getTravelTime() {
        return "";
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Train " + trainNumber + " leaves from " + departureStation + " on " + getFormattedDepartureTime() + " and arrives at " + arrivalStation + " on " + getFormattedArrivalTime();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }
}
