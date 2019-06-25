package com.example.hanapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void on1(View v) {

        Toast.makeText(getApplicationContext(), "열렸습니다.", Toast.LENGTH_SHORT).show();
    }
    public void on2(View v){

        Toast.makeText(getApplicationContext(),"잠겼습니다.",Toast.LENGTH_SHORT).show();
    }
    public void exit(View v) {
        finishAffinity();
    }
    public void back(View v) {
        finish();
    }
}
