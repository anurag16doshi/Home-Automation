package com.example.pujithad.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class VideoFeedActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> spinnerList = new ArrayList<>();
    Button ViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_feed);
        spinner = (Spinner) findViewById(R.id.spinnervideofeed);

        spinnerList.add("Choose the Door");
        spinnerList.add("MainFloor");
        spinnerList.add("FirstFloor");

        ViewButton = (Button) findViewById(R.id.viewvideoId);
        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(VideoFeedActivity.this, android.R.layout.simple_spinner_item, spinnerList);
        // Specify the layout to use when the list of choices appears
        spin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spin_adapter);
        onItemSelectedListener();
    }

    private void onItemSelectedListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Door = spinner.getSelectedItem().toString();
                if (Door.equals("MainFloor") | Door.equals("FirstFloor")) {

                    ViewButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Toast.makeText(getBaseContext(), "Video Plays", Toast.LENGTH_SHORT).show();


                        }
                    });
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}


