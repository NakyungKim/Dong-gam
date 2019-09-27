package com.example.otpapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate start in MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e(TAG, "onCreate end in MainActivity");
    }
}
