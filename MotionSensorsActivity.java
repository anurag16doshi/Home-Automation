package com.example.pujithad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MotionSensorsActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> spinnerList = new ArrayList<>();
    Button onsensorButton;
    Button offsensorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_sensors);

        spinner = (Spinner) findViewById(R.id.spinnerMotionsensor);
        spinnerList.add("Choose the Door");
        spinnerList.add("MainFloor");
        spinnerList.add("FirstFloor");

        offsensorButton = (Button) findViewById(R.id.MotionSensorOffId);
        onsensorButton = (Button) findViewById(R.id.motionsensoronId);
        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(MotionSensorsActivity.this, android.R.layout.simple_spinner_item, spinnerList);
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

                    onsensorButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(getBaseContext(), "Motion Sensor is ON", Toast.LENGTH_SHORT).show();

                        }
                    });

                    offsensorButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getBaseContext(), "Motion Sensor is OFF", Toast.LENGTH_SHORT).show();

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
