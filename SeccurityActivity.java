package com.example.pujithad.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeccurityActivity extends AppCompatActivity {
    EditText status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccurity);
        status=(EditText) findViewById(R.id.editTextstatus);

        Button armButton = (Button) findViewById(R.id.armbutton);
        armButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Security System Enabled", Toast.LENGTH_SHORT).show();
               status.setText("Security Enabled");


            }
        });

        Button disarmButton = (Button) findViewById(R.id.disarmbutton);
        disarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Security System Disabled", Toast.LENGTH_SHORT).show();
                status.setText("Security Disabled");


            }
        });
        Button armstayButton = (Button) findViewById(R.id.armstaybutton);
        armstayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Security System is in ARMStay MODE", Toast.LENGTH_SHORT).show();
                status.setText("Security ArmStay");


            }
        });
    }
}
