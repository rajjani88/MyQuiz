package com.raj.myquiz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.raj.myquiz.MainActivity;
import com.raj.myquiz.R;

public class SplashActivity extends AppCompatActivity {


    TextView tvCount;
    int counter  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //hide title bar
        getSupportActionBar().hide();

        //find
        tvCount = findViewById(R.id.tvCount);

        //start count here
        startCount();


    }

    void  openHomePage(){
        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(i);
    }

    void startCount() {
        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long l) {

                tvCount.setText("" + counter);
                counter++;

            }

            @Override
            public void onFinish() {
                tvCount.setText("Timer finish");
                openHomePage();
                finish();

            }
        }.start();


    }
}