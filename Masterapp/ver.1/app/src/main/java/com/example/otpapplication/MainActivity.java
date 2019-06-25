package com.example.otpapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on1(View v) {

        Toast.makeText(getApplicationContext(), "닫혔습니다.", Toast.LENGTH_SHORT).show();

    }

    public void on2(View v) {

        Toast.makeText(getApplicationContext(), "열렸습니다.", Toast.LENGTH_SHORT).show();
    }

    public void on3(View v) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}

