package com.example.otpapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate start in MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate end in MainActivity");
    }

    public void close(View v) {

        Toast.makeText(getApplicationContext(), "Closed", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate close in MainActivity");

    }

    public void open(View v) {

        Toast.makeText(getApplicationContext(), "Opended", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onCreate open in MainActivity");
    }

    public void UserList(View v) {
        Log.e(TAG, "onCreate userlist in MainActivity");
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}

