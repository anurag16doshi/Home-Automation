package com.example.pujithad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class LockActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String> spinnerList = new ArrayList<>();
    Button openButton;
    Button closeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        spinner = (Spinner) findViewById(R.id.spinnerlockActivity);
        spinnerList.add("Choose the Door");
        spinnerList.add("MainDoor");
        spinnerList.add("BackDoor");
        spinnerList.add("GarrageDoor1");
        spinnerList.add("GarrageDoor2");

        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(LockActivity.this, android.R.layout.simple_spinner_item, spinnerList);
        // Specify the layout to use when the list of choices appears
        spin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spin_adapter);
        onItemSelectedListener();

        openButton = (Button) findViewById(R.id.LockopenButton);
        closeButton = (Button) findViewById(R.id.LockCloseButton);

    }

    private void onItemSelectedListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Door = spinner.getSelectedItem().toString();
                if (Door.equals("MainDoor")|Door.equals("BackDoor")|Door.equals("GarrageDoor1")|Door.equals("GarrageDoor2")) {
                    openButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getBaseContext(),spinner.getSelectedItem().toString()+"Opened",Toast.LENGTH_SHORT).show();

                        }
                    });

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(getBaseContext(),spinner.getSelectedItem().toString()+"Closed",Toast.LENGTH_SHORT).show();

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
