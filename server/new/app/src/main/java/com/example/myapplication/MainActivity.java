package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import  android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v4.app.*;
import  android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  TextView tv_outPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_outPut = (TextView) findViewById(R.id.tv_outPut);

        String url = "52.79.242.88";

        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();
    }
    public class NetworkTask extends AsyncTask<Void, Void, String>{
        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values){

            this.url = url;
            this.values = values;
        }

        protected  String doInBackground(Void... params){

            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result =requestHttpURLConnection.request(url, values);

            return result;
        }

        protected void onPostExecute(String s){
            super.onPostExecute(s);

            tv_outPut.setText(s);
        }
    }
}
