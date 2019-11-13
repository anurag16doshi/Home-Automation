package com.example.pujithad.finalproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class background extends AsyncTask<String, Void,String> {
    String value;
    Context c;
    Handler h = new Handler();

    background(View.OnClickListener c) {
        this.c = (Context) c;
    }


    @Override
    protected String doInBackground(String... strings) {
        String url ="http://10.220.59.15/login.php/";
        try {
            URL myurl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)myurl.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            value = reader.readLine();

            h.post(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(c,value,Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception e)
        {

        }
        return null;
    }

}


    /*AlertDialog dialog;
    Context context;
    public Boolean login = false;
    public background(View.OnClickListener context)
    {
        this.context = (Context) context;
    }


    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }
    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.show();
        if(s.contains("login successful"))
        {
            Intent intent_name = new Intent();
            intent_name.setClass(context.getApplicationContext(),ConsumerWelcomePage.class);
            context.startActivity(intent_name);
        }
    }
    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String user = voids[0];
        String pass = voids[1];

        String connstr = "http://localhost/login.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")
                    +"&&"+URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line ="";
            while ((line = reader.readLine()) != null)
            {
                result += line;
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;
    }

}*/
