package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView tvClock;
    private Handler handler = new Handler();
    private Runnable clockRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClock = findViewById(R.id.tvClock);

        clockRunnable = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sdf =
                        new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                String currentTime = sdf.format(new Date());
                tvClock.setText(currentTime);

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(clockRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(clockRunnable);
    }
}