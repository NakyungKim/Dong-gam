package com.example.otpapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate start in MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate end in MainActivity");
    }

    public void open(View v) {

        //Toast.makeText(getApplicationContext(), "Opended", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate open in MainActivity");

        // donggam
        new MainActivity.MakeNetworkCall().execute("http://52.79.242.88:80/http.php?get=1", "Get");

    }

    public void close(View v) {

        Toast.makeText(getApplicationContext(), "Closed", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate close in MainActivity");
    }

    public void UserList(View v) {
        Log.e(TAG, "onCreate userlist in MainActivity");
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    InputStream ByGetMethod(String ServerURL) {

        Log.e(TAG, "ByGetMethod started in MainActivity");
        Log.e(TAG, "ServerURL = " + ServerURL);

        InputStream DataInputStream = null;
        try {
            URL url = new URL(ServerURL);
            HttpURLConnection cc = (HttpURLConnection)url.openConnection();
            cc.setReadTimeout(5000);
            cc.setConnectTimeout(5000);
            cc.setRequestMethod("GET");
            cc.setDoInput(true);
            cc.connect();

            int response = cc.getResponseCode();

            if (response == HttpURLConnection.HTTP_OK) {
                DataInputStream = cc.getInputStream();
                //Log.e(TAG, "ByGetMethod, DataInputStream = " + DataInputStream);
            }
            else {
                Log.e(TAG, "ByGetMethod, response = " + response);
            }

        } catch (Exception e) {
            Log.e(TAG, "Error in ByGetMethod", e);
        }

        Log.e(TAG, "ByGetMethod ended in HttpExampleActivity");

        return DataInputStream;
    }

    InputStream ByPostMethod(String ServerURL) {

        Log.e(TAG, "ByPostMethod started in HttpExampleActivity");

        InputStream DataInputStream = null;
        try {
            String PostParam = "first_name=dong&last_name=gam";

            URL url = new URL(ServerURL);

            HttpURLConnection cc = (HttpURLConnection)url.openConnection();
            if(cc == null) {
                Log.e(TAG, "ByPostMethod, cc is null");
            }
            cc.setReadTimeout(5000);
            cc.setConnectTimeout(5000);
            cc.setRequestMethod("POST");
            cc.setDoInput(true);
            cc.connect();

            DataOutputStream dos = new DataOutputStream(cc.getOutputStream());
            dos.writeBytes(PostParam);
            dos.flush();
            dos.close();

            int response = cc.getResponseCode();

            if (response == HttpURLConnection.HTTP_OK) {
                DataInputStream = cc.getInputStream();
            }
            else {
                Log.e(TAG, "ByPostMethod, response = " + response);
            }

        } catch (Exception e) {
            Log.e(TAG, "Error in PostData, error = " + e);
        }

        Log.e(TAG, "ByPostMethod ended in HttpExampleActivity");

        return DataInputStream;
    }

    String ConvertStreamToString(InputStream stream) {
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder response = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error in ConvertStreamToString, error = " + e);
        } catch (Exception e) {
            Log.e(TAG, "Error in ConvertStreamToString", e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                Log.e(TAG, "Error in ConvertStreamToString", e);
            } catch (Exception e) {
                Log.e(TAG, "Error in ConvertStreamToString", e);
            }
        }

        return response.toString();
    }

    public void DisplayMessage(String a) {

//        TxtResult = (TextView) findViewById(R.id.response);
//        TxtResult.setText(a);
    }

    private class MakeNetworkCall extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DisplayMessage("Please Wait ...");
        }

        @Override
        protected String doInBackground(String... arg) {
            InputStream is = null;
            String URL = arg[0];
            Log.e(TAG, "doInBackground started in HttpExampleActivity, URL: " + URL);
            String res = "";

            Log.e(TAG, "doInBackground, arg[1] = " + arg[1]);
            if (arg[1].equals("Post")) {
                is = ByPostMethod(URL);
            } else if (arg[1].equals("Get")) {
                is = ByGetMethod(URL);
            } else {
                Log.e(TAG, "doInBackground, do nothing, arg[1] = " + arg[1]);
            }

            if (is != null) {
                res = ConvertStreamToString(is);
            } else {
                res = "Something went wrong";
            }
            return res;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            DisplayMessage(result);
            Log.e(TAG, "onPostExecute, result: " + result);
        }
    }
}

