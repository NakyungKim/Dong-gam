package com.example.hanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

        Toast.makeText(getApplicationContext(),"로그인 되었습니다", Toast.LENGTH_SHORT).show(); //로그 추가

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void on2(View v) {

        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
    }
    public void exit(View v) {
        finish();
    }
}
