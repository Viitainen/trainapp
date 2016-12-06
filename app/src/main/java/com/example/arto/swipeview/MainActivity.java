package com.example.arto.swipeview;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.arto.swipeview.train.JourneySection;
import com.example.arto.swipeview.train.TimeTableRow;
import com.example.arto.swipeview.train.Train;
import com.example.arto.swipeview.train.TrainAPI;
import com.example.arto.swipeview.train.TrainArrivalDeparture;
import com.example.arto.swipeview.train.TrainAssembly;
import com.example.arto.swipeview.train.TrainStationToStationAtDate;
import com.example.arto.swipeview.train.Wagon;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public final static int SHORT_CODE_REQUEST_CODE_FOR_STATION = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_station_short_codes:
                Intent intent = new Intent(this, StationShortCodesActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Section: On Time
    public void handleBtnOnTimeSearchClick(View view) {
        EditText et = (EditText) findViewById(R.id.et_train_id);
        String id = et.getText().toString();

        if(id.isEmpty()) {
            Toast.makeText(this, "Please insert ID", Toast.LENGTH_SHORT).show();
            return;
        }

        //Disable button
        Button btn = (Button) findViewById(R.id.btn_on_time_search);
        btn.setEnabled(false);

        CheckIfTrainOnTimeTask task = new CheckIfTrainOnTimeTask();
        task.execute(id);
    }


    //Section: On Time - History
    public void handleBtnHistoryOnTimeSearch(View view) {
        EditText et = (EditText) findViewById(R.id.et_train_id);
        String id = et.getText().toString();

        if(id.isEmpty()) {
            Toast.makeText(this, "Please insert ID", Toast.LENGTH_SHORT).show();
            return;
        }

        String dateString;

        DatePicker datePicker = (DatePicker) findViewById(R.id.dp_history_on_time);

        //dateString = datePicker.getYear() + "-" + String.format(Locale.ENGLISH, "%02d", (datePicker.getMonth()+1)) + "-" + String.format(Locale.ENGLISH, "%02d", datePicker.getDayOfMonth());
        dateString = getDateFromDatePicker(datePicker);


        CheckIfTrainOnTimeTask task = new CheckIfTrainOnTimeTask();
        task.execute(id, dateString);
    }

    //Section: Station
    public void handleBtnStationSearchClick(View view) {


        //Get the station short code
        EditText et = (EditText) findViewById(R.id.et_station_short_code);
        String code = et.getText().toString();

        if(code.isEmpty()) {
            Toast.makeText(this, R.string.insert_station_code, Toast.LENGTH_SHORT).show();
            return;
        }

        //Disable search button
        Button btn = (Button) findViewById(R.id.btn_station_search);
        btn.setEnabled(false);


        GetStationArrivalsAndDeparturesTask task = new GetStationArrivalsAndDeparturesTask();
        task.execute(code);
    }

    //Section: Search.
    public void handleBtnSearchClick(View view) {

        EditText et = (EditText) findViewById(R.id.et_search_arrival_station);
        String arrivalStationCode = et.getText().toString();

        et = (EditText) findViewById(R.id.et_search_departure_station);

        String departureStationCode = et.getText().toString();

        if(arrivalStationCode.isEmpty() || departureStationCode.isEmpty()) {
            Toast.makeText(this, R.string.insert_station_codes, Toast.LENGTH_SHORT).show();
            return;
        }


        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        //String.format("%02d", month);
        String dateString = getDateFromDatePicker(datePicker);

        //dateString = datePicker.getYear() + "-" + String.format(Locale.ENGLISH, "%02d", (datePicker.getMonth()+1)) + "-" + String.format(Locale.ENGLISH, "%02d", datePicker.getDayOfMonth());

        GetTrainsFromStationAToStationBAtDateTask task = new GetTrainsFromStationAToStationBAtDateTask();
        task.execute(arrivalStationCode, departureStationCode, dateString);
    }


    //Section: Station.
    public void handleBtnStationShortCodeClick(View view) {
        Intent intent = new Intent(this, StationShortCodesActivity.class);
        startActivityForResult(intent, SHORT_CODE_REQUEST_CODE_FOR_STATION);
    }

    //Section: Details/Compositions
    public void handleBtnCompositionsSearchClick(View view) {

        EditText et = (EditText) findViewById(R.id.et_compositions_trainid);
        String id = et.getText().toString();

        if(id.isEmpty()) {
            Toast.makeText(this, R.string.insert_id, Toast.LENGTH_SHORT).show();
            return;
        }


        DatePicker datePicker = (DatePicker) findViewById(R.id.dp_compositions_date);

        String dateString = getDateFromDatePicker(datePicker);

        GetCompositionsTask task = new GetCompositionsTask();

        task.execute(id, dateString);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            EditText et = (EditText) findViewById(R.id.et_station_short_code);
            et.setText(data.getStringExtra("SHORTCODE"));
            Log.d("JUNA", "Shortcode: " + data.getStringExtra("SHORTCODE"));
        }
    }


    private class CheckIfTrainOnTimeTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {

            try {
                if (params.length > 1 && params[1] != null && !params[1].isEmpty()) {
                    return TrainAPI.getTrainOnTimeHistory(params[0], params[1]);
                }

                return TrainAPI.getTrainOnTime(params[0]);

            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

            return null;
        }

        protected void onPostExecute(String json) {

            TextView tv = (TextView) findViewById(R.id.tv_on_time_result);

            if (json == null || json.contains("errorMessage")) {
                tv.setText(R.string.could_not_fetch_with_id);
                //Enable the search button
                Button btn = (Button) findViewById(R.id.btn_on_time_search);
                btn.setEnabled(true);
                return;
            }

            Gson gson = new Gson();

            Type collectionType = new TypeToken<Collection<Train>>() {
            }.getType();
            Collection<Train> t = gson.fromJson(json, collectionType);

            Train train;

            if(t != null && !t.isEmpty()) {
                train = (Train) t.toArray()[0];
            } else {
                train = null;
            }

            if(train != null && train.getTimeTableRows().size() >= 1) {
                int lastIndex = train.getTimeTableRows().size() - 1;
                int difference;
                TimeTableRow tbr = train.getTimeTableRows().get(lastIndex);

                if(tbr.getDifferenceInMinutes() != null) {
                    difference = tbr.getDifferenceInMinutes();

                    if(difference == 0) {
                        tv.setText(R.string.train_on_time);
                        tv.setTextColor(Color.DKGRAY);
                    } else if (difference > 0) {
                        tv.setText(getString(R.string.train_running_late_by) + Integer.toString(difference) + getString(R.string.minutes_end_of_sentence));
                        tv.setTextColor(Color.RED);
                    } else {
                        tv.setText(getString(R.string.train_ahead_by) + Integer.toString(difference).replace("-","") + getString(R.string.minutes_end_of_sentence));
                        tv.setTextColor(Color.CYAN);
                    }
                } else if(!train.getRunningCurrently()) {
                    tv.setText(R.string.train_not_running);
                    tv.setTextColor(Color.DKGRAY);
                } else {
                    tv.setText(R.string.could_not_get_on_time);
                }

            } else {
                tv.setText(R.string.train_not_running);
                tv.setTextColor(Color.DKGRAY);
            }

            //Enable the search button
            Button btn = (Button) findViewById(R.id.btn_on_time_search);
            btn.setEnabled(true);

            /*


            if (trains.length != 0 && trains[0].getRunningCurrently()) {
                int lastIndex = trains[0].getTimeTableRows().size() - 1;

                int difference = trains[0].getTimeTableRows().get(lastIndex).getDifferenceInMinutes();
                Log.d("JUNA", "Difference: " + trains[0].getTimeTableRows().get(lastIndex).getStationShortCode() + " | " + Integer.toString(difference));

                if (difference == 0) {
                    tv.setText(R.string.train_on_time);
                    tv.setTextColor(Color.DKGRAY);
                } else if (difference > 0) {
                    tv.setText(getString(R.string.train_running_late_by) + Integer.toString(difference) + getString(R.string.minutes_end_of_sentence));
                    tv.setTextColor(Color.RED);
                } else {
                    tv.setText(getString(R.string.train_ahead_by) + Integer.toString(difference) + getString(R.string.minutes_end_of_sentence));
                    tv.setTextColor(Color.CYAN);
                }
            } else {
                tv.setText(R.string.train_not_running);
                tv.setTextColor(Color.DKGRAY);
            }

            //Enable the search button
            Button btn = (Button) findViewById(R.id.btn_on_time_search);
            btn.setEnabled(true);
            */
        }

    }

    private class GetTrainsFromStationAToStationBAtDateTask extends AsyncTask<String, Void, String[]> {

        protected String[] doInBackground(String... trainData) {

            String json = "";

            try {
                if(!trainData[0].isEmpty() && !trainData[1].isEmpty() && !trainData[2].isEmpty()) {
                    json = TrainAPI.getTrainsFromStationToStationAtDate(trainData[0], trainData[1], trainData[2]);
                    return new String[]{json,trainData[0],trainData[1],trainData[2]};
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }


            return null;

            }
            /*else {
                Toast.makeText(getApplicationContext(), R.string.check_fields, Toast.LENGTH_SHORT).show();
            }
            */

        protected void onPostExecute(String[] data) {

            if (data[0].isEmpty() || data[0].contains("errorMessage")) {
                Toast.makeText(getApplicationContext(), R.string.no_results, Toast.LENGTH_SHORT).show();
                return;
            }

            List<TrainStationToStationAtDate> trains = new ArrayList<>();

            //Init gson object
            Gson gson = new Gson();

            //Deserialize json to train objects
            Type collectionType = new TypeToken<Collection<Train>>() {
            }.getType();
            Collection<Train> t = gson.fromJson(data[0], collectionType);

            String arrivalTime;
            String departureTime;

            for (Train train : t) {
                arrivalTime = "";
                departureTime = "";

                for (TimeTableRow item : train.getTimeTableRows()) {

                    boolean arrival = item.getType().equalsIgnoreCase("ARRIVAL");

                    if (!arrival && item.getStationShortCode().equalsIgnoreCase(data[1])) {
                        departureTime = item.getScheduledTime();
                    } else if (arrival && item.getStationShortCode().equalsIgnoreCase(data[2])) {
                        arrivalTime = item.getScheduledTime();
                    }

                    //If both values already obtained, break from TimeTableRow loop
                    if (!arrivalTime.isEmpty() && !departureTime.isEmpty()) {
                        break;
                    }
                }

                TrainStationToStationAtDate record = new TrainStationToStationAtDate(train.getTrainNumber(), data[1], data[2], departureTime, arrivalTime);

                trains.add(record);

            }

            if (trains != null && !trains.isEmpty()) {
                String[] trainArray = new String[trains.size()];

                for (int i = 0; i < trains.size(); i++) {
                    trainArray[i] = trains.get(i).toString();
                    if (trainArray[i] == null) {
                        trainArray[i] = " ";
                    }
                }

                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                intent.putExtra("data", trainArray);
                intent.putExtra("title", "Trains");

                getApplicationContext().startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), R.string.no_results, Toast.LENGTH_SHORT).show();
            }

        }
    }


    private class GetStationArrivalsAndDeparturesTask extends AsyncTask<String, Void, List<TrainArrivalDeparture>> {

        protected List<TrainArrivalDeparture> doInBackground(String... stationCode) {

            String json = "";

            try {
                json = TrainAPI.getStationsArrivalsAndDepartures(stationCode[0]);

                Gson gson = new Gson();

                //Deserialize json to train objects
                Type collectionType = new TypeToken<Collection<Train>>() {
                }.getType();
                Collection<Train> t = gson.fromJson(json, collectionType);
                List<TrainArrivalDeparture> trains = new ArrayList<TrainArrivalDeparture>();

                for (Train train : t) {
                    for (TimeTableRow item : train.getTimeTableRows()) {

                        if (item.getStationShortCode().equalsIgnoreCase(stationCode[0])) {
                            boolean arrival = item.getType().equalsIgnoreCase("ARRIVAL");
                            boolean ok = false;


                            //Format of the Date from the API call
                            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);

                            Date date = new Date();
                            Date dateNow = new Date();

                            try {
                                //Convert to date object
                                date = df.parse(item.getScheduledTime().replace("Z", "-0000"));

                                if (date.after(new Date())) {
                                    ok = true;
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            if (ok) {

                                TrainArrivalDeparture trainArrivalDeparture = new TrainArrivalDeparture(train.getTrainNumber(), item.getType(), item.getScheduledTime());
                                trains.add(trainArrivalDeparture);
                            }
                        }
                    }
                }

                return trains;

            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

            return null;
        }

        protected void onPostExecute(List<TrainArrivalDeparture> trains) {

            if (trains == null) {
                //Enable the search button
                Button btn = (Button) findViewById(R.id.btn_station_search);
                btn.setEnabled(true);
                return;
            }

            if (trains.size() == 0) {
                Toast.makeText(getApplicationContext(), R.string.no_results, Toast.LENGTH_LONG).show();
            } else {

                String[] trainArray = new String[trains.size()];
                for (int i = 0; i < trains.size(); i++) {
                    trainArray[i] = trains.get(i).toString();
                    if (trainArray[i] == null) {
                        trainArray[i] = " ";
                    }
                }

                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                intent.putExtra("data", trainArray);
                intent.putExtra("title", getString(R.string.arrivals_and_departures));

                getApplicationContext().startActivity(intent);
            }

            //Enable the search button
            Button btn = (Button) findViewById(R.id.btn_station_search);
            btn.setEnabled(true);
        }
    }


    private class GetCompositionsTask extends AsyncTask<String, Void, TrainAssembly> {

        protected TrainAssembly doInBackground(String... params) {

            try {
                String json = TrainAPI.getCompositions(params[0], params[1]);

                Gson gson = new Gson();

                //Deserialize json to TrainAssembly objects
                TrainAssembly trainAssembly;
                trainAssembly = gson.fromJson(json, TrainAssembly.class);

                return trainAssembly;
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

            return null;
        }

        protected void onPostExecute(TrainAssembly trainAssembly) {


            //Get the first trainAssebmly journeysection
            if (trainAssembly != null && !trainAssembly.getJourneySections().isEmpty() && trainAssembly.getJourneySections().size() >= 1) {
                JourneySection js = trainAssembly.getJourneySections().get(0);
                List<Wagon> wagons = js.getWagons();

                String[] stringArray = new String[wagons.size()];

                for(int i = 0; i < wagons.size(); i++) {
                    stringArray[i] = wagons.get(i).toString();
                }

                Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
                intent.putExtra("data", stringArray);
                intent.putExtra("title", getString(R.string.wagons_and_services_of) + trainAssembly.getTrainNumber());
                startActivity(intent);

            }
            else {
                Toast.makeText(getApplicationContext(), getString(R.string.no_results), Toast.LENGTH_SHORT).show();
            }

        }
    }


    public static class OnTimeFragment extends Fragment {

        public OnTimeFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static OnTimeFragment newInstance() {
            return new OnTimeFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_on_time, container, false);
            return rootView;
        }

    }

    /**
     * A Details fragment containing a simple view.
     */
    public static class DetailsFragment extends Fragment {

        public DetailsFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         */
        public static DetailsFragment newInstance() {
            return new DetailsFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_details, container, false);
            return rootView;
        }
    }

    /**
     * A Details fragment containing a simple view.
     */
    public static class StationFragment extends Fragment {

        public StationFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         */
        public static StationFragment newInstance() {
            return new StationFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_station, container, false);
            return rootView;
        }

    }

    /**
     * A Details fragment containing a simple view.
     */
    public static class SearchFragment extends Fragment {

        public SearchFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         */
        public static SearchFragment newInstance() {
            return new SearchFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_search, container, false);
            return rootView;
        }

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return OnTimeFragment.newInstance();
                case 1:
                    return SearchFragment.newInstance();
                case 2:
                    return StationFragment.newInstance();
                case 3:
                    return DetailsFragment.newInstance();

            }

            return OnTimeFragment.newInstance();
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "On Time";
                case 1:
                    return "Search";
                case 2:
                    return "Station";
                case 3:
                    return "Details";
            }
            return null;
        }


    }


    private String getDateFromDatePicker(DatePicker datePicker) {
        if (datePicker != null)
            return datePicker.getYear() + "-" + String.format(Locale.ENGLISH, "%02d", (datePicker.getMonth() + 1)) + "-" + String.format(Locale.ENGLISH, "%02d", datePicker.getDayOfMonth());
        else return "";
    }

}
