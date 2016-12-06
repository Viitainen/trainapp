package com.example.arto.swipeview.train;

import android.util.Log;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Arto on 14.11.2016.
 */

public class TrainArrivalDeparture implements Serializable {

    public TrainArrivalDeparture(int trainNumber, String type, String time) {
        this.trainNumber = trainNumber;
        this.type = type;
        this.time = time;
    }

    private int trainNumber;

    private String type;

    private String time;


    public Integer getTrainNumber() {
        return trainNumber;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time.replace("Z", "-0000");
    }

    @Override
    public String toString() {
        String arrivesOrDeparts = "arrives/departs";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
        Date date = new Date();
        String dateString = "";

        try {
            date = df.parse(getTime());
            SimpleDateFormat ft = new SimpleDateFormat("HH.mm");
            dateString = ft.format(date);
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

        if(type.equalsIgnoreCase("ARRIVAL")) {
            arrivesOrDeparts = "arrives";
        } else if(type.equalsIgnoreCase("DEPARTURE")) {
            arrivesOrDeparts = "departs";
        }

        return "Train " + trainNumber + " " + arrivesOrDeparts + " at " + dateString;
    }
}
