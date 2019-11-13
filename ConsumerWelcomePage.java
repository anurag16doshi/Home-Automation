package com.example.pujithad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConsumerWelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_welcome_page);

        Button AlarmButton = (Button) findViewById(R.id.AlarmActivityButtonWelcomePage);
        AlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConsumerWelcomePage.this,SeccurityActivity.class);
                startActivity(i);
            }
        });

        Button AppliancesButton = (Button) findViewById(R.id.ViewAppliancesButttonWelcomePage);
        AppliancesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConsumerWelcomePage.this,AppliancesActivity.class);
                startActivity(i);
            }
        });

        Button lockButton = (Button) findViewById(R.id.LockButtonWelcomePage);
        lockButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConsumerWelcomePage.this,LockActivity.class);
                startActivity(i);
            }
        });

        Button SensorButton = (Button) findViewById(R.id.SensorButtonWelcomePage);
        SensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConsumerWelcomePage.this,MotionSensorsActivity.class);
                startActivity(i);
            }
        });

        Button WeatherButton = (Button) findViewById(R.id.WeatherInfoButton);
        WeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConsumerWelcomePage.this,WeatherActivity.class);
                startActivity(i);
            }
        });

        Button AccountSettingButton = (Button) findViewById(R.id.AccountSettingsButton);
        AccountSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ConsumerWelcomePage.this,AccountSettingsActivity.class);
                startActivity(i);
            }
        });

    }
}
