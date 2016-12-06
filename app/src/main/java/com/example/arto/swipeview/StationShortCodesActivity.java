package com.example.arto.swipeview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class StationShortCodesActivity extends AppCompatActivity {

    ListView listview;
    EditText filter;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_short_codes);

        listview = (ListView) findViewById(R.id.lv_station_short_codes);
        filter = (EditText) findViewById(R.id.et_filter_station_short_codes);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.station_short_codes));

        listview.setAdapter(adapter);

        /*

*/

        //Listen for the click
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

                String shortCode = "";
                shortCode = adapter.getAdapter().getItem(position).toString();

                //Get the shortCode from the string
                shortCode = shortCode.substring(shortCode.lastIndexOf(':') + 1).trim();

                if(getCallingActivity() != null) {
                    Log.d("JUNA", "Shjortcode: "+ shortCode);
                    Intent intent = new Intent();
                    intent.putExtra("SHORTCODE", shortCode);
                    setResult(2, intent);
                    finish();
                }
            }
        });


        //Filter array when filter edit text changes
        filter.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                StationShortCodesActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }




}
