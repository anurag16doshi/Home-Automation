package com.example.pujithad.finalproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    Spinner spinner;
    ArrayList<String> spinnerList = new ArrayList<>();
    Button loginButton;
    EditText usrName;
    EditText pwd;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.Typeofuser);
        spinnerList.add("Choose type of User");
        spinnerList.add("Consumer");
        spinnerList.add("PowerGenerator");
        spinnerList.add("UtilityCompany");


        loginButton = (Button) findViewById(R.id.MainLoginbutton);
        //    Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerList);
        // Specify the layout to use when the list of choices appears
        spin_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spin_adapter);


        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, ConsumerWelcomePage.class));
            return;
        }

        usrName = (EditText) findViewById(R.id.Enterloginname);
        pwd = (EditText) findViewById(R.id.Enterloginpwd);
        // onItemSelectedListener();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


    }


    private void userLogin() {
        final String username = usrName.getText().toString().trim();
        final String password = pwd.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {

                            JSONObject obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                                obj.getInt("id"),
                                                obj.getString("username"),
                                                obj.getString("name")
                                        );


                                startActivity(new Intent(getApplicationContext(), ConsumerWelcomePage.class));
                                finish();
                            } else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
    @Override
    public void onClick(View view) {
        if(view ==  loginButton){
            userLogin();
        }
    }
  /*  private void onItemSelectedListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String UserType = spinner.getSelectedItem().toString();

                if (UserType.equals("Consumer")) {
                    loginButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Toast.makeText(getBaseContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                             //usrName = (EditText) findViewById(R.id.Enterloginname);
                             //pwd = (EditText) findViewById(R.id.Enterloginpwd);

                            String  user=usrName.getText().toString();
                            String  pass=pwd.getText().toString();
                            background bk=new background(this);
                            bk.execute();


                            Intent i = new Intent(MainActivity.this, ConsumerWelcomePage.class);
                            startActivity(i);
                        }
                    });
                }
                else if (UserType.equals("PowerGenerator")){

                    loginButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Toast.makeText(getBaseContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                           // usrName = (EditText) findViewById(R.id.Enterloginname);
                            //pwd = (EditText) findViewById(R.id.Enterloginpwd);

                            Intent i = new Intent(MainActivity.this, PowerGenerator.class);
                            startActivity(i);
                        }
                    });
                }
                else if (UserType.equals("UtilityCompany")){
                    loginButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Toast.makeText(getBaseContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                            // usrName = (EditText) findViewById(R.id.Enterloginname);
                             //pwd = (EditText) findViewById(R.id.Enterloginpwd);

                            Intent i = new Intent(MainActivity.this, UtilityCompanyActivity.class);
                            startActivity(i);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/






}