package com.example.pujithad.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Button Changepasswordbutton = (Button) findViewById(R.id.ChangePwdButtonId);
        Changepasswordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText Name = (EditText) findViewById(R.id.ChangeUserName);
                EditText Pwd = (EditText) findViewById(R.id.ChangePwdTextId);

                //  Toast.makeText(getBaseContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
