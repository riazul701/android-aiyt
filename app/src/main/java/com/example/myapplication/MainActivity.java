package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextClock textClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock = (TextClock) findViewById(R.id.textClockId);
        analogClock = (AnalogClock) findViewById(R.id.analogClockId);

        textClock.setOnClickListener(this);
        analogClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.textClockId) {
            Toast.makeText(MainActivity.this, "Text clock", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.analogClockId) {
            Toast.makeText(MainActivity.this, "Analog clock", Toast.LENGTH_SHORT).show();
        }
    }
}
